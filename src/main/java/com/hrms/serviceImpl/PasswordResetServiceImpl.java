package com.hrms.serviceImpl;

import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.hrms.entities.User;
import com.hrms.exceptions.ResourceNotFoundException;
import com.hrms.repository.UserRepository;
import com.hrms.services.PasswordResetService;

@Service
public class PasswordResetServiceImpl implements PasswordResetService {
	
	@Autowired
    private JavaMailSender mailSender;

    @Autowired
    private UserRepository userRepository;
    
    @Value("${spring.mail.username}")
	private String fromMail;
    
    private static final long OTP_EXPIRATION_TIME_MS = 5 * 60 * 1000; // 5 minutes
    
 // Map to store OTPs with email as key and OTP information as value
    private Map<String, OtpInfo> otpStorage = new ConcurrentHashMap<>();
    
    @Override
    public void initiatePasswordReset(String email) {
        String otp = generateOTP();
        storeOTP(email, otp, System.currentTimeMillis() + OTP_EXPIRATION_TIME_MS);
        sendOTPEmail(email, otp);
    }
    private String generateOTP() {
        Random random = new Random();
        int otp = 100000 + random.nextInt(900000);
        return String.valueOf(otp);
    }
    private void sendOTPEmail(String email, String otp) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(fromMail);
        message.setTo(email);
        message.setSubject("Password Reset OTP");
        message.setText("Your OTP for password reset is: " + otp);

        mailSender.send(message);
    }
    // Define a class to hold OTP information
    private static class OtpInfo {
        private String otp;
        private long expirationTime;

        public OtpInfo(String otp, long expirationTime) {
            this.otp = otp;
            this.expirationTime = expirationTime;
        }

        public String getOtp() {
            return otp;
        }

        public long getExpirationTime() {
            return expirationTime;
        }
    }
    @Override
    public boolean resetPassword(String email, String otp, String newPassword) {
        if (!verifyOTP(email, otp)) {
            return false;
        }

        User user = userRepository.findByEmail(email).orElseThrow(()-> new ResourceNotFoundException("Email Address Not Found !!! "));
        user.setPassword(newPassword);
        userRepository.save(user);

        deleteOTP(email);

        return true;
    }

    
    private void storeOTP(String email, String otp, long expirationTime) {
        otpStorage.put(email, new OtpInfo(otp, expirationTime));
    }

    private boolean verifyOTP(String email, String otp) {
        OtpInfo otpInfo = otpStorage.get(email);
        if (otpInfo != null && otpInfo.getOtp().equals(otp) && System.currentTimeMillis() < otpInfo.getExpirationTime()) {
            return true;
        }
        return false;
    }

    private void deleteOTP(String email) {
        otpStorage.remove(email);
    }
    

}

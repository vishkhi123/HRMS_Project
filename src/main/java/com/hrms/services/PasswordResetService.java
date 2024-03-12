package com.hrms.services;

public interface PasswordResetService {
	
	void initiatePasswordReset(String email);
	
	public boolean resetPassword(String email, String otp, String newPassword);

}

package com.hrms.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hrms.entities.LoginUser;
import com.hrms.entities.User;
import com.hrms.services.PasswordResetService;
import com.hrms.services.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
    private PasswordResetService passwordResetService;
	
	@PostMapping("/register")
	public ResponseEntity<User> create(@Valid @RequestBody User user)
	{
		return new ResponseEntity<User>(this.userService.create(user), HttpStatus.ACCEPTED);
	}
	
	@PostMapping("/login")
	public ResponseEntity<User> login(@Valid @RequestBody LoginUser loginUser)
	{
		return new ResponseEntity<User>(this.userService.login(loginUser), HttpStatus.OK);
	}
	
	@PostMapping("/forgot-password")
    public ResponseEntity<String> forgotPassword(@RequestParam("email") String email) 
	{
        passwordResetService.initiatePasswordReset(email);
        return ResponseEntity.ok("Password reset instructions sent to your email.");
    }
	@PostMapping("/reset-password")
    public ResponseEntity<String> resetPassword(@RequestParam("email") String email,
                                                @RequestParam("otp") String otp,
                                                @RequestParam("newPassword") String newPassword) 
	{
        if (passwordResetService.resetPassword(email, otp, newPassword)) {
            return ResponseEntity.ok("Password reset successful.");
        } else {
            return ResponseEntity.badRequest().body("Invalid OTP or expired link.");
        }
    }


}

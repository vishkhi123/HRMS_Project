package com.hrms.entities;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class LoginUser {
	
	@Email(message = "Invalid Email")
	@Pattern(regexp = "^([a-zA-Z0-9._%-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,5})$",message = "Invalid Email")
	private String email;
	
	@Size(min = 3, max = 20, message = "Invalid Password !!")
	private String password;

}

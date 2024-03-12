package com.hrms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.hrms.entities.Role;
import com.hrms.entities.User;
import com.hrms.exceptions.ResourceNotFoundException;
import com.hrms.repository.UserRepository;

@SpringBootApplication
public class HrmsApplication implements CommandLineRunner {
	
	@Autowired
	private UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(HrmsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		try {
			User existingUser = userRepository.findByEmailIgnoreCase("admin@gmail.com");
			if (existingUser == null) {
				
				User newUser=new User();
				newUser.setName("admin");
				newUser.setEmail("admin@gmail.com");
				newUser.setPassword("admin");
				newUser.setRole(Role.APP_ADMIN);
				userRepository.save(newUser);
				
			} else {
				System.out.println("User with email 'admin@gmail.com' already exists.");
			}
			
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		
		
	}

}

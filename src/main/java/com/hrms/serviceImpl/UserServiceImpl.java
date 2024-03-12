package com.hrms.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrms.entities.LoginUser;
import com.hrms.entities.User;
import com.hrms.exceptions.ResourceNotFoundException;
import com.hrms.repository.UserRepository;
import com.hrms.services.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;

	//register user
	@Override
	public User create(User user) {
		// TODO Auto-generated method stub
		User userSaved=this.userRepository.save(user);
		return userSaved;
	}

	//login user
	@Override
	public User login(LoginUser login) {
		// TODO Auto-generated method stub
		String email=login.getEmail();
		String password=login.getPassword();
		
		User loggedUser=this.userRepository.findByEmailAndPassword(email, password).orElseThrow(()-> new ResourceNotFoundException("Email And Password Does not Match!!"));
		return loggedUser;
	}

}

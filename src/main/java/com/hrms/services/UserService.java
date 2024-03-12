package com.hrms.services;

import com.hrms.entities.LoginUser;
import com.hrms.entities.User;

public interface UserService {
	//register
	User create(User user);
	//login user
	User login(LoginUser login);

}

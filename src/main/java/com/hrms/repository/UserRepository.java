package com.hrms.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hrms.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	Optional<User> findByEmailAndPassword(String email,String password);
	
	Optional<User> findByEmail(String email);
	
	User findByEmailIgnoreCase(String email);
	

}

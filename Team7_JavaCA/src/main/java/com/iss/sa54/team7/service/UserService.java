package com.iss.sa54.team7.service;

import java.util.List;
import java.util.Optional;

import com.iss.sa54.team7.model.User;

public interface UserService {

	public List<User> findAllUsers();
	public Optional<User> findUserById(int id);
	public User findUserByUsername(String name);
	
}

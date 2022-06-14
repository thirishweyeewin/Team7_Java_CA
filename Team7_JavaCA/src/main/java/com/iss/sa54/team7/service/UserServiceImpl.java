package com.iss.sa54.team7.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iss.sa54.team7.model.User;
import com.iss.sa54.team7.repo.UserRepo;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepo urepo;
	
	@Override
	public List<User> findAllUsers() {
		return urepo.findAll();
	}

	@Override
	public Optional<User> findUserById(int id) {
		return urepo.findById(id);
	}

	@Override
	public User findUserByUsername(String name) {
		User user = urepo.findUserByUsername(name);
		if (user == null)
			return null;
		
		return user;
	}

}

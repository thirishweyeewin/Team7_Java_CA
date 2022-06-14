package com.iss.sa54.team7.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.iss.sa54.team7.model.User;

public interface UserRepo extends JpaRepository<User, Integer> {
	
	public User findUserByUsername(String name);

}

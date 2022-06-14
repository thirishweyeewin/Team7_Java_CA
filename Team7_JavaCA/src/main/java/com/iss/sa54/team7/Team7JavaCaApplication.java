package com.iss.sa54.team7;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import com.iss.sa54.team7.model.RoleType;
import com.iss.sa54.team7.model.User;
import com.iss.sa54.team7.repo.UserRepo;

@SpringBootApplication
public class Team7JavaCaApplication {

	@Autowired
	UserRepo urepo;
	
	public static void main(String[] args) {
		SpringApplication.run(Team7JavaCaApplication.class, args);
	}
	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
	   return args ->{	
//		   User user1 = new User("Mike", "aaa", RoleType.STUDENT);
//		   User user2 = new User("Tin", "aaa", RoleType.LECTURER);
//		   User user3 = new User("Jean", "aaa", RoleType.ADMIN);
//		   urepo.save(user1);
//		   urepo.save(user2);
//		   urepo.save(user3);
		   
		   
	   };
	   }

}

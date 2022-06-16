package com.iss.sa54.team7;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.scrypt.SCryptPasswordEncoder;

import com.iss.sa54.team7.model.RoleType;
import com.iss.sa54.team7.model.User;
import com.iss.sa54.team7.repo.UserRepo;

@SpringBootApplication(exclude= {SecurityAutoConfiguration.class })
public class Team7JavaCaApplication {

	@Autowired
	UserRepo urepo;
	
	public static void main(String[] args) {
		SpringApplication.run(Team7JavaCaApplication.class, args);
	}
	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
	   return args ->{
		   
//		   SCryptPasswordEncoder encoder = new SCryptPasswordEncoder();
//		   String hashedPassword = encoder.encode("mmm");
//		   String hashedPassword1 = encoder.encode("ttt");
//		   String hashedPassword2 = encoder.encode("jjj");
//		   
//		   User user1 = new User("Mike", hashedPassword, RoleType.STUDENT);
//		   User user2 = new User("Tin", hashedPassword1, RoleType.LECTURER);
//		   User user3 = new User("Jean", hashedPassword2, RoleType.ADMIN);
//		   urepo.save(user1);
//		   urepo.save(user2);
//		   urepo.save(user3);
		   
		   
	   };
	   }

}

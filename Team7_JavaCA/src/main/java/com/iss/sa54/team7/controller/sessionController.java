package com.iss.sa54.team7.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.scrypt.SCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.iss.sa54.team7.model.RoleType;
import com.iss.sa54.team7.model.User;
import com.iss.sa54.team7.service.UserService;

@Controller
@RequestMapping("/home")
public class sessionController {

	@Autowired
	UserService uservice;
	
	@RequestMapping("/viewLoginForm")
	public String viewLoginForm(Model model) {
		
		User user = new User();
		model.addAttribute("user", user);
		model.addAttribute("hasError", "false");
		return "login";
	}
	
	@RequestMapping("/authenticate")
	public String authenticate() {
		return "forward:/home/viewLoginForm";
	}
	
	@PostMapping("/authenticate")
	public String authenticate(@ModelAttribute("user") User user, HttpSession session, Model model) {
		
		if (user.getPassword() == null || 
				user.getUsername().isBlank() || 
				user.getPassword().isBlank() || 
				user.getUsername() == null) {
			model.addAttribute("isNull", "true");
			return "forward:/home/viewLoginForm";
		}

		User userFromDb = uservice.findUserByUsername(user.getUsername());
		String nextPage = "";
		
		if (userFromDb == null) {
			model.addAttribute("exist", "true");
			return "forward:/home/viewLoginForm";
		}
		
		if (authenticateUser(user, userFromDb)) {
			RoleType role = userFromDb.getRole();
			if (role == RoleType.ADMIN)
				nextPage = "admMainPage";
			else if(role == RoleType.LECTURER)
				nextPage = "lectMainPage";
			else
				nextPage = "stuMainPage";
			
			session.setAttribute("currentUser", user);
		}
		else {
			model.addAttribute("wrong", "true");
			nextPage = "forward:/home/viewLoginForm";
		}
		
		return nextPage;
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("currentUser");
		session.invalidate();
		return "index";
	}
	
	private boolean authenticateUser(User user, User userFromDb) {
		SCryptPasswordEncoder encoder = new SCryptPasswordEncoder();
		return encoder.matches(user.getPassword(), userFromDb.getPassword());
	}
	
}



package com.bob.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bob.models.User;
import com.bob.service.UserService;

@RestController
public class UserController {
	@Autowired
	private UserService userService;
//	@CrossOrigin(origins = {"http://localhost:3000/signup"}, maxAge=6000)
	@RequestMapping(value="/signup", method = RequestMethod.POST)
	public String userSignup( @RequestBody User user) {
//		if(result.hasErrors()) {
//			System.out.println(result);
//			return "Error please try again";
//		}
		
			System.out.println(user.getPassword());
			System.out.println(user.getEmail());
//			userService.saveWithUserRole(user);
			return "SignupSuccessful";
			
		
//		return "SignupSuccessful";
	}
	
//	@RequestMapping(value="/login", method = RequestMethod.POST)
//	public String Login(@RequestBody User user) {
//		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//		String existingPassword = user.
//		String dbPassword       = ... // Load hashed DB password
//
//		if (passwordEncoder.matches(existingPassword, dbPassword)) {
//		    // Encode new password and store it
//		} else {
//		    // Report error 
//		}
//	}

}

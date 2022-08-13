package com.fernanda.wideond.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fernanda.wideond.entities.profiles.User;
import com.fernanda.wideond.services.UserService;

@RestController
@RequestMapping(value = "/api/user")
public class UserResource {

	@Autowired
	private UserService service;
	
	@GetMapping
	public List<User> findAll(){
		List<User> users = service.findAll();
		return users;
	}
			
	// TODO find by name
	// TODO find all skills
	// TODO find skill
	// TODO find portfolio
	// TODO find all work experiences
	
}

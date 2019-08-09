package com.bae.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bae.entity.User;
import com.bae.logic.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	public UserController(UserService service) {
		this.service = service;
	}

	public UserService service;

	@PostMapping("/create")
	public User createUser(@RequestBody User user) {

		return service.createUser(user);
	}

}

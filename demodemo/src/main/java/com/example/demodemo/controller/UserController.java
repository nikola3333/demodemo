package com.example.demodemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demodemo.model.User;

import com.example.demodemo.service.UserService;

@RestController
@RequestMapping("/v1")
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping("/users")
	public List<User> getUsers() {
		return userService.getUsers();
	}

	@GetMapping("/user/{username}")
	public User getUserByUsername(@PathVariable("username") String username) {
		return userService.getUserByUsername(username);
	}

	@PostMapping("/addUser")
	public void addUser(@RequestBody User user) {

		userService.addUser(user);

	}

	@DeleteMapping("/deleteUser")
	public void deleteUser(@RequestBody User user) {

		userService.deleteUser(user);

	}
	
	@PutMapping("/updateUser")
	public void updateuser(@RequestBody User user) {

		userService.updateUser(user);

	}

}

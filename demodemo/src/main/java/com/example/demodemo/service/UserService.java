package com.example.demodemo.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demodemo.model.User;
import com.example.demodemo.repository.UserRepositoryCrud;
import com.example.demodemo.repository.UserRepositoryImpl;

@Service
public class UserService {

	@Autowired
	private UserRepositoryImpl userRepository;

	@Transactional
	public List<User> getUsers() {

		// return (List<User>) userRepository.findAll();
		return userRepository.getUsers();
	}

	@Transactional
	public User getUserByUsername(String username) {
		return userRepository.getUserByUsername(username);
	}

	@Transactional
	public void addUser(User user) {
		userRepository.addUser(user);
	}
	
	@Transactional
	public void deleteUser(User user) {
		userRepository.deleteUser(user);
	}

	@Transactional
	public void updateUser(User user) {
		userRepository.updateUser(user);
	}
	
}

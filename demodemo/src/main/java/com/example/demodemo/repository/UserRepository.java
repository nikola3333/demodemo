package com.example.demodemo.repository;

import java.util.List;

import com.example.demodemo.model.User;

public interface UserRepository {
	
	public List<User> getUsers();
	
	public User getUserByUsername(String username);
	
	public void addUser(User user);
	
	public void deleteUser(User user);
	
	public void updateUser(User user);

}

package com.example.demodemo.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.demodemo.model.User;

public interface UserRepositoryCrud extends CrudRepository<User, Integer>{

}

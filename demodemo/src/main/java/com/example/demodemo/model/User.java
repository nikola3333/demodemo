package com.example.demodemo.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {


	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	@Column(name = "first_name")
	private final String first_name;
	
	@Column(name = "last_name")
	private final String last_name;
	
	@Column(name = "username")
	private final String username;
	
	@Column(name = "password")
	private final String password;

	public User() {
		//super();
		this.id = id;
		this.first_name = "";
		this.last_name = "";
		this.username = "";
		this.password = "";
	}

	public User(Integer id, String first_name, String last_name, String username, String password) {
		super();
		this.id = id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.username = username;
		this.password = password;
	}
	
	public User(String first_name, String last_name, String username, String password) {
		super();
		this.first_name = first_name;
		this.last_name = last_name;
		this.username = username;
		this.password = password;
	}

	public Integer getId() {
	    return id;
	  }

	  public void setId(Integer id) {
	    this.id = id;
	  }
	
		/*
		 * public String getFirstName() { return first_name; }
		 * 
		 * public String getLastName() { return last_name; }
		 */

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	
	
	public String getFirst_name() {
		return first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	@Override
	public String toString() {
		return "User [id=" + id + "first_name=" + first_name + ", last_name=" + last_name + ", username=" + username + ", password="
				+ password + "]";
	}
	
	
}

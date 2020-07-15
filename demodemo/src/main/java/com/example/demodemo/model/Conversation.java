package com.example.demodemo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Conversation {

	@Column(name = "first_username")
	private final String first_username;
	
	@Column(name = "second_username")
	private final String second_username;
	
	@Id
	@Column(name = "conversation_id")
	private final String conversation_id;
	
	public Conversation() {
		this.first_username = "";
		this.second_username = "";
		this.conversation_id = "";
	}

	public Conversation(String first_username, String second_username, String conversation_id) {
		super();
		this.first_username = first_username;
		this.second_username = second_username;
		this.conversation_id = conversation_id;
	}

	public String getFirst_username() {
		return first_username;
	}

	public String getSecond_username() {
		return second_username;
	}

	public String getConversation_id() {
		return conversation_id;
	}

	@Override
	public String toString() {
		return "Conversation [first_username=" + first_username + ", second_username=" + second_username
				+ ", conversation_id=" + conversation_id + "]";
	}
	
	
	
	
	
}

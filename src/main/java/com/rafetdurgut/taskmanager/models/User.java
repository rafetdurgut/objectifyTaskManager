package com.rafetdurgut.taskmanager.models;

import java.util.ArrayList;
import java.util.List;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Index;

@Entity
public class User {
	
	private @Id Long id;
	private @Index String name;
	private String password;
	private @Index  String email;
	private Long createdAt;
	private Long updatedAt;
	private List<TodoList> todos = new ArrayList<>();

	
	public User() {
		
	}
	public User(String name, String password, String email) {
		this.name = name;
		this.password = password;
		this.email = email;
		this.createdAt = System.currentTimeMillis();
		this.updatedAt = System.currentTimeMillis();
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long userId) {
		this.id = userId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Long getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Long createdAt) {
		this.createdAt = createdAt;
	}
	public Long getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Long updatedAt) {
		this.updatedAt = updatedAt;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public List<TodoList> getTodos() {
		return todos;
	}
	public void setTodos(List<TodoList> todos) {
		this.todos = todos;
	}
	public void clone(User old)
	{
		this.name = old.getName();
		this.password = old.getPassword();
		this.email = old.getEmail();
		this.createdAt = old.getCreatedAt();
		this.updatedAt = System.currentTimeMillis();
	}

	@Override
	public String toString() {
		return "User [userId=" + id + ", name=" + name + ", password=" + password + ", email=" + email
				+ ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + "]";
	}
	
}

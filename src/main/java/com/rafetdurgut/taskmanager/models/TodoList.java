package com.rafetdurgut.taskmanager.models;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Index;
@Entity
public class TodoList {
	
	

	private @Id Long id;
	private @Index String title;
	private String description;
	private Long deadline;
	private Long createdAt;
	private Long updatedAt;
	private @Index Long userId;
	
	
	
	public TodoList() {
	}
	public TodoList(Long id, String title, String description, Long deadline, Long createdAt, Long updatedAt,
			Long userId) {
		this.id = id;
		this.title = title;
		this.description = description;
		this.deadline = deadline;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.userId = userId;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getDeadline() {
		return deadline;
	}

	public void setDeadline(Long deadline) {
		this.deadline = deadline;
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
	public void clone(TodoList todo) {
		if(todo.title != null)
			this.title = todo.title;
		if(todo.deadline != null)
			this.deadline = todo.deadline;
		if(todo.description != null)
			this.description = todo.description;
		this.updatedAt = System.currentTimeMillis();
	}
	
	
	
	
	
	
}

package com.rafetdurgut.taskmanager.models;


import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Index;
import com.rafetdurgut.taskmanager.enums.Category;
import com.rafetdurgut.taskmanager.utilities.Constants;

@Entity
public class TaskItem {
	private @Id Long id;
	private @Index String title;
	private String description;
	private @Index Category category;
	private @Index Long todoListId;
	
	
	

	

	public TaskItem() {
		this.title = Constants.EMPTY;
		this.description = Constants.EMPTY;
		this.category = Category.DEFAULT;
	}
	
	public TaskItem(Long id, String title, String description, Category category, Long todoListId) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.category = category;
		this.todoListId = todoListId;
	}
	public Long getTodoListId() {
		return todoListId;
	}

	public void setTodoListId(Long todoListId) {
		this.todoListId = todoListId;
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
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}

	public void clone(TaskItem task) {
		if(task.category != null)
			this.category = task.category;
		if(task.description != null)
			this.description = task.description;
		if(task.title != null)
			this.title = task.title;
	}
}

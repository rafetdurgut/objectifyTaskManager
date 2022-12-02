package com.rafetdurgut.taskmanager.services;

import static com.googlecode.objectify.ObjectifyService.ofy;

import java.util.List;

import com.google.api.server.spi.response.NotFoundException;
import com.rafetdurgut.taskmanager.models.TodoList;

public class TodoService {
	
	public static List<TodoList> getAllTodos(){
		
		
		return ofy()
				.load()
				.type(TodoList.class)
				.list();
	}
	
	public static TodoList addTodo(TodoList todo)
	{
		ofy().save().entity(todo).now();
		return todo;
	}
	public static TodoList getTodo(Long id) throws NotFoundException
	{
		TodoList todo =  ofy().load().type(TodoList.class).id(id).now();
		if(todo == null)
			throw new NotFoundException("Todo List not found.");
		return todo;
	}

	public static void deleteTodo(Long id) throws NotFoundException {
		ofy().delete().entity(getTodo(id)).now();
	}

	public static List<TodoList> getTodosByUser(Long userId) {
		return ofy().load().type(TodoList.class).filter("userId =",userId).list();
	}
	
}

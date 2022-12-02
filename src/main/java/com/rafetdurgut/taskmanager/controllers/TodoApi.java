package com.rafetdurgut.taskmanager.controllers;

import static com.googlecode.objectify.ObjectifyService.ofy;

import java.util.List;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.Named;
import com.google.api.server.spi.config.ApiMethod.HttpMethod;
import com.google.api.server.spi.response.NotFoundException;
import com.rafetdurgut.taskmanager.models.Comment;
import com.rafetdurgut.taskmanager.models.TaskItem;
import com.rafetdurgut.taskmanager.models.TodoList;
import com.rafetdurgut.taskmanager.models.User;
import com.rafetdurgut.taskmanager.services.CommentService;
import com.rafetdurgut.taskmanager.services.TaskItemService;
import com.rafetdurgut.taskmanager.services.TodoService;
import com.rafetdurgut.taskmanager.services.UserService;
import com.rafetdurgut.taskmanager.utilities.Constants;

@Api(name="todo", version="v1",
scopes = {Constants.EMAIL_SCOPE },
clientIds = {Constants.WEB_CLIENT_ID, Constants.API_EXPLORER_CLIENT_ID },
description = "API for user endpoints.")
public class TodoApi {
	
	/*  User Endpoints */
	
	@ApiMethod(name = "users", path="users", httpMethod = HttpMethod.GET)
	public List<User> getAllUsers()
	{
		return  UserService.getAllUsers();
	}
	@ApiMethod(name = "users", path = "users/{userId}", httpMethod = HttpMethod.GET)
	public User getUser(@Named("userId") Long userId) throws NotFoundException
	{
		return UserService.getUser(userId);
	}
	
	@ApiMethod(name = "users", path = "users", httpMethod = HttpMethod.POST)
	public User addUser(User u)
	{
		ofy().save().entity(u).now();
		return ofy().load().entity(u).now();
	}
	
	@ApiMethod(name = "users", path = "users/{userId}", httpMethod = HttpMethod.DELETE)
	public void deleteUser(@Named("userId") Long userId) throws NotFoundException
	{
		UserService.deleteUser(userId);
	}
	
	@ApiMethod(name = "update", path = "users/{userId}", httpMethod = HttpMethod.PUT)
	public User updateUser(@Named("userId") Long userId, User u) throws NotFoundException
	{
		User user = getUser(userId);
		user.clone(u);
		ofy().save().entity(user).now(); 
		return user;
	}
	
	

	
	
	/* Todo Endpoints */
	@ApiMethod(name = "todos", path = "users/{userId}/todos", httpMethod = HttpMethod.GET)
	public List<TodoList> getUserTodos(@Named("userId") Long userId)
	{
		return TodoService.getTodosByUser(userId);
	}
	@ApiMethod(name = "todos", path = "users/{userId}/todos", httpMethod = HttpMethod.POST)
	public TodoList addUserTodos(@Named("userId") Long userId, TodoList todo)
	{
		todo.setUserId(userId);
		TodoService.addTodo(todo);
		return todo;
	}
	
	@ApiMethod(name = "allTodos", path = "todos", httpMethod = HttpMethod.GET)
	public List<TodoList> getAllTodos() throws NotFoundException
	{		
		return TodoService.getAllTodos();        
	}
	@ApiMethod(name = "userTodo", path = "todos/{todoId}", httpMethod = HttpMethod.GET)
	public TodoList getUserTodo(@Named("todoId") Long todoId) throws NotFoundException
	{		
		return TodoService.getTodo(todoId);
        
	}
	
	@ApiMethod(name = "delete", path = "todos/{todoId}/", httpMethod = HttpMethod.DELETE)
	public void deleteTodo(@Named("todoId") Long todoId) throws NotFoundException
	{
		TodoService.deleteTodo(todoId);
	}
	
	@ApiMethod(name = "update",  path = "todos/{todoId}/", httpMethod = HttpMethod.PUT)
	public TodoList updateTodo(@Named("todoId") Long todoId, TodoList todo) throws NotFoundException
	{
		TodoList todoList = TodoService.getTodo(todoId);
		todoList.clone(todo);
		return TodoService.getTodo(todoId);
	}
	
	//Task Item Endpoints
	@ApiMethod(name = "todos", path = "tasks",
            httpMethod = HttpMethod.GET)
	public List<TaskItem> getAllTasks()
	{
		 return TaskItemService.getAllTask();
	}
	@ApiMethod(name = "tasks", path = "todos/{todoId}/tasks",
            httpMethod = HttpMethod.GET)
	public List<TaskItem> getAllTasksByTodo(@Named("todoId") Long todoId)
	{
		 return TaskItemService.getAllTask(todoId);
	}
	@ApiMethod(name = "tasks", path = "todos/{todoId}/tasks",
            httpMethod = HttpMethod.POST)
	public TaskItem addTaskToTodoList(@Named("todoId") Long todoId, TaskItem task)
	{
		 return TaskItemService.addTask(task, todoId);
	}
	@ApiMethod(name = "tasks", path = "tasks/{taskId}",
            httpMethod = HttpMethod.GET)
	public TaskItem getTask(@Named("taskId") Long taskId) throws NotFoundException
	{
		return TaskItemService.getTask(taskId);
	}
	
	@ApiMethod(name = "tasks", path = "tasks/{taskId}",
            httpMethod = HttpMethod.DELETE)
	public void deleteTask(@Named("taskId") Long taskId) throws NotFoundException
	{
		 TaskItemService.deleteTask(taskId);
	}

	@ApiMethod(name = "tasks", path = "tasks/{taskId}",
            httpMethod = HttpMethod.PUT)
	public TaskItem updateTask(@Named("taskId") Long taskId, TaskItem task) throws NotFoundException
	{
		return  TaskItemService.updateTask(taskId, task);
	}
	
	
	//Comment Endpoints
	@ApiMethod(name = "tasksComments", path = "tasks/{taskId}/comments",
            httpMethod = HttpMethod.GET)
	public List<Comment> getCommentsByTask(@Named("taskId") Long taskId)
	{
		return  CommentService.getCommentByTask(taskId);
	}
	
	@ApiMethod(name = "addTaskComment", path = "tasks/{taskId}/comments",
            httpMethod = HttpMethod.POST)
	public Comment addCommentsByTask(@Named("taskId") Long taskId, Comment comment)
	{
		return  CommentService.addComment(comment,taskId);
	}
	@ApiMethod(name = "getComment", path = "comments/{commentID}",
            httpMethod = HttpMethod.GET)
	public void getComment(@Named("commentID") Long commentID) throws NotFoundException
	{
		 CommentService.getComment(commentID);
	}
	
	@ApiMethod(name = "deleteComment", path = "comments/{commentID}",
            httpMethod = HttpMethod.DELETE)
	public void deleteComment(@Named("commentID") Long commentID) throws NotFoundException
	{
		CommentService.deleteComment(commentID);
	}

	@ApiMethod(name = "updateComment", path = "comments/{taskId}",
            httpMethod = HttpMethod.PUT)
	public Comment updateComment(@Named("taskId") Long taskId, Comment comment) throws NotFoundException
	{
		return  CommentService.updateComment(taskId, comment);
	}
}

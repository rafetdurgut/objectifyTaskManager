package com.rafetdurgut.taskmanager.services;


import java.util.List;

import com.google.api.server.spi.response.NotFoundException;
import com.rafetdurgut.taskmanager.models.TodoList;
import com.rafetdurgut.taskmanager.models.User;
import static com.googlecode.objectify.ObjectifyService.ofy;

public class UserService {

	public static List<User> getAllUsers(){

		return ofy()
				.load()
				.type(User.class)
				.list();
	}
	
	public static User addUser(User u)
	{
		 ofy().save().entity(u).now();
		 return u;
	}
	
	public static User getUser(Long userId) throws NotFoundException
	{
		User user = ofy().load().type(User.class).id(userId).now();
		if(user == null)
			throw new NotFoundException("User not found.");
		user.setTodos(ofy().load().type(TodoList.class).filter("userId =",userId).list());
		return user;
	}

	public static void deleteUser(Long userId) throws NotFoundException {
		User user = getUser(userId);
		ofy().delete().entity(user).now();
		
	}
}

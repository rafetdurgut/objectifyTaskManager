package com.rafetdurgut.taskmanager.services;

import static com.googlecode.objectify.ObjectifyService.ofy;

import java.util.List;

import com.google.api.server.spi.response.NotFoundException;
import com.rafetdurgut.taskmanager.models.TaskItem;

public class TaskItemService {
	
	public static List<TaskItem> getAllTask(){
//		List<Key<TaskItem>> keys = ofy().load().type(TaskItem.class).keys().list();
//		ofy().delete().keys(keys).now();
//		
		return ofy()
				.load()
				.type(TaskItem.class)
				.list();
	}
	
	public static TaskItem addTask(TaskItem task, Long listId)
	{
		task.setTodoListId(listId);
		ofy().save().entity(task).now();
		return task;
	}

	public static TaskItem getTask(Long id) throws NotFoundException
	{
		TaskItem task =  ofy().load().type(TaskItem.class).id(id).now();
		if(task == null)
			throw new NotFoundException("Task Item is not found.");
		return task;
	}
	
	public static TaskItem updateTask(Long id, TaskItem task) throws NotFoundException
	{
		TaskItem taskItem =  getTask(id);
		taskItem.clone(task);
		return taskItem;
	}
	
	public static void deleteTask(Long id) throws NotFoundException {
		ofy().delete().entity( getTask(id) );
	}

	public static List<TaskItem> getAllTask(Long todoId) {
		// TODO Auto-generated method stub
		return ofy().load().type(TaskItem.class).filter("todoListId =",todoId).list();
		}
}

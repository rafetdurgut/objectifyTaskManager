package com.rafetdurgut.taskmanager.services;

import static com.googlecode.objectify.ObjectifyService.ofy;

import java.util.List;

import com.google.api.server.spi.response.NotFoundException;
import com.rafetdurgut.taskmanager.models.Comment;

public class CommentService {
	
	public static List<Comment> getAllComments(){
		return ofy()
				.load()
				.type(Comment.class)
				.list();
	}
	
	public static Comment addComment(Comment comment, Long taskId)
	{
		comment.setTaskId(taskId);
		ofy().save().entity(comment).now();
		return comment;
	}

	public static Comment getComment(Long id) throws NotFoundException
	{
		Comment comment =  ofy().load().type(Comment.class).id(id).now();
		
		if(comment == null)
				throw new NotFoundException("Comment is not found");
		return comment;
	}
	
	public static Comment updateComment(Long id, Comment comment) throws NotFoundException
	{
		
		Comment _comment =  getComment(id);
		_comment.clone(comment);
		return _comment;
	}
	
	public static void deleteComment(Long id) throws NotFoundException {
		ofy().delete().entity(getComment(id)).now();
	}

	public static List<Comment> getCommentByTask(Long taskId) {
		// TODO Auto-generated method stub
		return ofy().load().type(Comment.class).filter("taskId =", taskId).list();
		}

}

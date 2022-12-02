package com.rafetdurgut.taskmanager.models;


import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Index;


@Entity
public class Comment {
	private	@Id Long id;
	private Long postedTime;
	private Long updatedAt;
	private @Index String comment;
	private @Index Long userId;
	private @Index Long taskId;
	
	
	public Comment() {
	}
	
	public Comment(Long id, Long postedTime, String comment, Long userId, Long taskId) {
		this.id = id;
		this.postedTime = System.currentTimeMillis();
		this.comment = comment;
		this.userId = userId;
		this.setUpdatedAt(System.currentTimeMillis());
		this.taskId =taskId;
	}
	public Long getTaskId() {
		return taskId;
	}

	public void setTaskId(Long taskId) {
		this.taskId = taskId;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getPostedTime() {
		return postedTime;
	}
	public void setPostedTime(Long postedTime) {
		this.postedTime = postedTime;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public void clone(Comment comment2) {
		if(comment2.comment != null)
			this.comment = comment2.comment;
		comment2.setUpdatedAt(System.currentTimeMillis());
	}

	public Long getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Long updatedAt) {
		this.updatedAt = updatedAt;
	}

}

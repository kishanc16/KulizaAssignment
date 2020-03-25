package com.kuliza.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.CreationTimestamp;

@Entity(name ="Comment")
public class CommentEntity {
	
	@Id
	@GeneratedValue
	@Column(name = "commentId")
	private long commentId;
	
	@CreationTimestamp
	@Column(name = "createdAt")
	private Date createdAt;
	
	@Size(min=3,message="cmment length should be atleast 3" )
	@NotNull
	private String comment;
	
	@NotNull
	@Column(name = "userId")
	private long userId;
	
	@ManyToOne
	@JoinColumn(name="blogid")
	BlogEntity blogEntity;
	
	public long getCommentId() {
		return commentId;
	}
	public String getComment() {
		return comment;
	}
	public void setCommentId(long commentId) {
		this.commentId = commentId;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public long getUserId() {
		return userId;
	}
	public BlogEntity getBlogEntity() {
		return blogEntity;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public void setBlogEntity(BlogEntity blogEntity) {
		this.blogEntity = blogEntity;
	}
	
	
	
}

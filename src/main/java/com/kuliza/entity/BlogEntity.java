package com.kuliza.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.CreationTimestamp;

@Entity(name ="Blog")
public class BlogEntity {
	
	@Id
	@GeneratedValue
	@Column(name = "blogId")
	private long blogId;
	
	@NotNull
	@Column(columnDefinition = "VARCHAR(100)")
	private String title;
	
	@NotNull
	@Column(columnDefinition = "VARCHAR(550)")
	private String body;
	
	@NotNull
	@Column(name="createdBy",columnDefinition = "VARCHAR(100)")
	private String createdBy;
	
	@CreationTimestamp
	@Column(name = "CreatedAt")
	private Date CreatedAt;
	
	@ManyToOne
	@JoinColumn(name="userid")
	UserEntity userEntity;
	
	@OneToMany(cascade=CascadeType.ALL)
	List<CommentEntity> commentEntity;
	
	public long getBlogId() {
		return blogId;
	}
	public void setBlogId(long blogId) {
		this.blogId = blogId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public Date getCreatedAt() {
		return CreatedAt;
	}
	public void setCreatedAt(Date createdAt) {
		CreatedAt = createdAt;
	}
	public UserEntity getUserEntity() {
		return userEntity;
	}
	public void setUserEntity(UserEntity userEntity) {
		this.userEntity = userEntity;
	}
	

}

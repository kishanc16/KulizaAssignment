package com.kuliza.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.CreationTimestamp;

/*
 * It is entity class which is pushed to database 
 * and getting value from userDto
 * */
@Entity(name = "User")
public class UserEntity {
	@Id
	@GeneratedValue
	private Long id;

	@NotNull
	@Column(columnDefinition = "VARCHAR(100)", nullable = false)
	private String firstName;

	@Column(columnDefinition = "VARCHAR(100)", nullable = true)
	private String lastName;

	@NotNull
	@Column(columnDefinition = "VARCHAR(100)", unique = true)
	private String email;

	@NotNull
	@Column(columnDefinition = "VARCHAR(50)", unique = true)
	private String phone;

	@Column(columnDefinition = "VARCHAR(100)")
	@Size(min = 6, message = "Password length Should be atleast 6")
	private String password;

	@CreationTimestamp
	private Date createdAt;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn
	List<BlogEntity> blogEntity;

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}

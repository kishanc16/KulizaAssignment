package com.kuliza.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class BlogDto {
	
	@NotEmpty(message = "Title cannot be Empty")
	@Size(min=6, max =50,message="Title length should be in between 6 to 50" )
	private String title;
	
	@NotEmpty(message = "Body cannot be Empty")
	@Size(min=30,message="Body length should be atleast 30" )
	private String body;
	
	
	
	public String getTitle() {
		return title;
	}
	public String getBody() {
		return body;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	public void setBody(String body) {
		this.body = body;
	}
		
}

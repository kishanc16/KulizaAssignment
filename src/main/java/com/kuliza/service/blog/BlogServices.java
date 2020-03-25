package com.kuliza.service.blog;

import org.springframework.http.ResponseEntity;

import com.kuliza.dto.BlogDto;

public interface BlogServices {
	
	public ResponseEntity<?> createBlog(long userId, BlogDto blogDto);
	public ResponseEntity<?> getBlogs(long userId);
	//public ResponseEntity<?> getAllComments(long blogId);
}

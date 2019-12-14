package com.kuliza.blog;

import org.springframework.http.ResponseEntity;

import com.kuliza.dto.BlogDto;

public interface BlogServices {
	
	public ResponseEntity<?> createBlog(long userId, BlogDto blogDto);
	public ResponseEntity<?> getBlogs(long userId);
}

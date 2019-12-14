package com.kuliza.api;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.kuliza.blog.BlogServices;
import com.kuliza.dto.BlogDto;

@RestController
public class BlogApi {
	
	@Autowired
	BlogServices blogServices;

	@PostMapping("api/user/{userId}/blog")
	public ResponseEntity<?> createBlog(@PathVariable long userId, @Valid @RequestBody BlogDto blogDto)
	{
		return blogServices.createBlog(userId, blogDto);
	}
	
	@GetMapping("api/user/{userId}/blogs")
	public ResponseEntity<?> getBlogs(@PathVariable long userId)
	{
		return blogServices.getBlogs(userId);
	}
}

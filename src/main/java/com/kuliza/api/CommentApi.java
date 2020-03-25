package com.kuliza.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.kuliza.dto.CommentDto;
import com.kuliza.service.comment.CommentService;

@RestController
public class CommentApi {
	
	@Autowired
	CommentService commentService;
	
	@PostMapping("api/user/{userId}/blog/{blogId}/comment")
	public ResponseEntity<?> createComment(@RequestBody CommentDto commentDto,
			@PathVariable("userId") long userId,@PathVariable("blogId") long blogId){
		return commentService.createComment(commentDto, userId, blogId);
	}
}

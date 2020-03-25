package com.kuliza.service.comment;

import org.springframework.http.ResponseEntity;

import com.kuliza.dto.CommentDto;

public interface CommentService {
	
	ResponseEntity<?> createComment(CommentDto commentDto,long userId, long blogId);
}

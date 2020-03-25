package com.kuliza.service.comment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.kuliza.dto.CommentDto;
import com.kuliza.entity.BlogEntity;
import com.kuliza.entity.CommentEntity;
import com.kuliza.entity.UserEntity;
import com.kuliza.exception.UserNotFoundException;
import com.kuliza.jpa.BlogJpaRepository;
import com.kuliza.jpa.CommentJpaRepo;
import com.kuliza.jpa.UserJpaRepo;

@Service
public class CommentServiceImpl implements CommentService {
	
	@Autowired
	CommentJpaRepo  commentJpaRepo;
	
	@Autowired
	UserJpaRepo userJpaRepo;

	@Autowired
	BlogJpaRepository blogJpaRepository;

	@Override
	public ResponseEntity<?> createComment(CommentDto commentDto, long userId, long blogId) {
		CommentEntity commentEntity = new CommentEntity();
		UserEntity userEntity = userJpaRepo.findOne(userId);
		if(userEntity == null)
			throw new UserNotFoundException("Invalid User Id : " + userId);
		
		BlogEntity blogEntity = blogJpaRepository.findOne(blogId);
		if(blogEntity != null) {
			commentEntity.setComment(commentDto.getComment());
			commentEntity.setUserId(userId);
			commentEntity.setBlogEntity(blogEntity);
				
			commentJpaRepo.save(commentEntity);
			
			return new ResponseEntity<>("Comment Created ",HttpStatus.OK);
		}
		return new ResponseEntity<>("Blog is not exist ",HttpStatus.BAD_REQUEST);		
	
	}


	
	
	
}

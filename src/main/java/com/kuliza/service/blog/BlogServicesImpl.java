package com.kuliza.service.blog;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.kuliza.dto.BlogCreatedMessage;
import com.kuliza.dto.BlogDto;
import com.kuliza.dto.ShowBlogMessageDto;
import com.kuliza.entity.BlogEntity;
import com.kuliza.entity.UserEntity;
import com.kuliza.exception.UserNotFoundException;
import com.kuliza.jpa.BlogJpaRepository;
import com.kuliza.jpa.UserJpaRepo;

@Service
public class BlogServicesImpl implements BlogServices{

	@Autowired
	UserJpaRepo userJpaRepo;

	@Autowired
	BlogJpaRepository blogJpaRepository;
	
	@Override
	public ResponseEntity<?> createBlog(long userId, BlogDto blogDto) {
		
		UserEntity userEntity = userJpaRepo.findOne(userId);
		if(userEntity == null)
			throw new UserNotFoundException("Invalid User Id : " + userId);
		
		BlogEntity blogEntity = new BlogEntity();
		blogEntity.setTitle(blogDto.getTitle());
		blogEntity.setBody(blogDto.getBody());
		blogEntity.setCreatedBy(userEntity.getFirstName());
		blogEntity.setUserEntity(userEntity);
		
		blogJpaRepository.save(blogEntity);
		
		BlogCreatedMessage message = new BlogCreatedMessage();
		message.setTimestamp(new Date());
		message.setUserId(userId);
		message.setBlogId(blogEntity.getBlogId());
		message.setTitle(blogDto.getTitle());
		message.setBody(blogDto.getBody());
				
		return new ResponseEntity<>(message, HttpStatus.OK);
	}

	/**
	 * get blogs
	 */
	@Override
	public ResponseEntity<?> getBlogs(long userId) {
		UserEntity userEntity = userJpaRepo.findOne(userId);
		if(userEntity == null)
			throw new UserNotFoundException("Invalid User Id : " + userId);
		
		List<BlogEntity> blogList= blogJpaRepository.findAllByUserId(userId);
		if(blogList.size() > 0) {
			List<ShowBlogMessageDto> showMessage = new ArrayList<ShowBlogMessageDto>();
			for(int i=0;i<blogList.size();i++)
			{
				BlogEntity blogEntity = blogList.get(i);
				ShowBlogMessageDto message = new ShowBlogMessageDto();
				message.setUserId(userId);
				message.setTitle(blogEntity.getTitle());
				message.setBody(blogEntity.getBody());
				message.setCreatedBy(blogEntity.getCreatedBy());
				message.setCreatedAt(blogEntity.getCreatedAt());
				showMessage.add(message);
			}		
			
			return new ResponseEntity<>(showMessage, HttpStatus.OK);	
		}
		return new ResponseEntity<>("No any blogs written by "+userEntity.getFirstName(),HttpStatus.BAD_REQUEST);
	}

}

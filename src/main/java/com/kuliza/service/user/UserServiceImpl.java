package com.kuliza.service.user;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.kuliza.dto.UpdatedMessageDto;
import com.kuliza.dto.UserCreatedMessageDto;
import com.kuliza.dto.UserDto;
import com.kuliza.entity.UserEntity;
import com.kuliza.exception.UserNotFoundException;
import com.kuliza.jpa.UserJpaRepo;

/**
 *It user service class
 *There are many services defined regarding user. 
 */
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserJpaRepo userJpaRepo;

	/**
	 * Adding new user 
	 */
	@Override
	public ResponseEntity<?> addUser(UserDto userDto) {
		UserEntity userEntity = new UserEntity();

		String name = userDto.getName();
		String fName, lName = null;

		if (name.indexOf(' ') != -1) {
			fName = name.substring(0, name.indexOf(' '));
			lName = name.substring(name.indexOf(' ') + 1);
		} else {
			fName = name;
		}

		userEntity.setFirstName(fName);
		userEntity.setLastName(lName);
		userEntity.setEmail(userDto.getEmail());
		userEntity.setPhone(userDto.getPhone());

		userJpaRepo.save(userEntity);

		UserCreatedMessageDto message = new UserCreatedMessageDto();
		message.setTimestamp(new Date());
		message.setUserId(userEntity.getId());
		message.setName(userDto.getName());
		message.setMessage("New User Created");

		return new ResponseEntity<>(message, HttpStatus.CREATED);
	}
	/**
	 * Getting user from database
	 */
	@Override
	public ResponseEntity<?> getUser(long userId) {

		UserEntity userEntity = userJpaRepo.findOne(userId);

		if (userEntity == null) {
			throw new UserNotFoundException("Invalid User Id : " + userId);
		}

		UserDto userDto = new UserDto();
		if (userEntity.getLastName() != null) {
			userDto.setName(userEntity.getFirstName() + " " + userEntity.getLastName());
		} else {
			userDto.setName(userEntity.getFirstName());
		}
		userDto.setEmail(userEntity.getEmail());
		userDto.setPhone(userEntity.getPhone());

		return new ResponseEntity<>(userDto, HttpStatus.OK);

	}

	/**
	 * Update user name
	 */
	public ResponseEntity<?> updateUserName(long userId, String name) {

		UserEntity userEntity = userJpaRepo.findOne(userId);
		if (userEntity == null) {
			throw new UserNotFoundException("Invalid User Id : " + userId);
		}
		if (name.length() > 0) {
			String fName, lName = null;

			if (name.indexOf(' ') != -1) {
				fName = name.substring(0, name.indexOf(' '));
				lName = name.substring(name.indexOf(' ') + 1);
			} else {
				fName = name;
			}
			userEntity.setFirstName(fName);
			userEntity.setLastName(lName);

			userJpaRepo.save(userEntity);

			UpdatedMessageDto message = new UpdatedMessageDto();
			message.setTimestamp(new Date());
			message.setUserId(userEntity.getId());
			message.setMessage("Name Updated");

			return new ResponseEntity<>(message, HttpStatus.OK);
		}
		return new ResponseEntity<>("Invalid Name", HttpStatus.BAD_REQUEST);
	}

	/**
	 * update password
	 */
	public ResponseEntity<?> updatePassword(long userId, String password) {
		UserEntity userEntity = userJpaRepo.findOne(userId);
		if (userEntity == null) {
			throw new UserNotFoundException("Invalid User Id : " + userId);
		}
		if (password.length() > 0) {
			userEntity.setPassword(password);

			userJpaRepo.save(userEntity);

			UpdatedMessageDto message = new UpdatedMessageDto();
			message.setTimestamp(new Date());
			message.setUserId(userEntity.getId());
			message.setMessage("Password Updated");

			return new ResponseEntity<>(message, HttpStatus.OK);
		}
		return new ResponseEntity<>("Invalid Name", HttpStatus.BAD_REQUEST);
	}

	/**
	 * delete user
	 */
	@Override
	public ResponseEntity<?> deleteUser(long userId) {
		UserEntity userEntity = userJpaRepo.findOne(userId);
		if (userEntity == null) {
			throw new UserNotFoundException("Invalid User Id : " + userId);
		}
		userJpaRepo.deleteById(userId);

		UpdatedMessageDto message = new UpdatedMessageDto();
		message.setTimestamp(new Date());
		message.setUserId(userEntity.getId());
		message.setMessage("User Deleted");

		return new ResponseEntity<>(message, HttpStatus.OK);
	}
}

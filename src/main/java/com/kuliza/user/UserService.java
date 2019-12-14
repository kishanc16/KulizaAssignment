package com.kuliza.user;

import org.springframework.http.ResponseEntity;

import com.kuliza.dto.UserDto;


public interface UserService {

	public ResponseEntity<?> addUser(UserDto userDto);

	public ResponseEntity<?> getUser(long userId);

	public ResponseEntity<?> updateUserName(long userId, String name);

	public ResponseEntity<?> updatePassword(long userId, String password);

	public ResponseEntity<?> deleteUser(long userId);

}

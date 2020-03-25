package com.kuliza.api;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kuliza.dto.UserDto;
import com.kuliza.service.user.UserService;

/*
 * It is controller class of User
 */ 
@RestController
public class UserApi {

	@Autowired
	UserService userService;

	@GetMapping()
	public String welcomeToBoot() {
		return "Welcome to Spring Boot";
	}

	@PostMapping("api/user")
	public ResponseEntity<?> addUser(@Valid @RequestBody UserDto userDto) {
		return userService.addUser(userDto);
	}

	@GetMapping("api/user/{userId}")
	public ResponseEntity<?> getUser(@PathVariable long userId) {
		return userService.getUser(userId);
	}

	@PatchMapping("api/user/{userId}/name")
	public ResponseEntity<?> updateUserName(@PathVariable long userId, @Valid @RequestParam String name) {
		return userService.updateUserName(userId, name);
	}

	@PatchMapping("api/user/{userId}/password")
	public ResponseEntity<?> updatePassword(@PathVariable long userId, @Valid @RequestHeader String password) {
		return userService.updatePassword(userId, password);
	}

	@DeleteMapping("api/user/{userId}/delete")
	public ResponseEntity<?> deleteUser(@PathVariable long userId) {
		return userService.deleteUser(userId);
	}

}

package com.ravi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ravi.exception.UserNotFoundException;
import com.ravi.request.UserRequest;
import com.ravi.response.UserResponse;
import com.ravi.service.IUserService;

import jakarta.validation.Valid;

@RestController
public class UserRestController {

	@Autowired
	private IUserService userService;

	@PostMapping(value = "/user", consumes = "application/json", produces = "application/json")
	public ResponseEntity<UserResponse> saveUser(@RequestBody @Valid UserRequest request) {
		UserResponse response = userService.saveUser(request);
		return new ResponseEntity<>(response,HttpStatus.CREATED);

	}

	@GetMapping(value = "/users", produces = "application/json")
	public ResponseEntity<List<UserResponse>> getUsers() {
		List<UserResponse> users = userService.getUsers();
		return new ResponseEntity<List<UserResponse>>(users, HttpStatus.OK);
	}

	@GetMapping(value = "/user/{userId}", produces = "application/json")
	public ResponseEntity<UserResponse> getUser(@PathVariable("userId") Integer userId)throws UserNotFoundException {
		UserResponse user = userService.getUser(userId);
		return new ResponseEntity<UserResponse>(user, HttpStatus.OK);
	}

}

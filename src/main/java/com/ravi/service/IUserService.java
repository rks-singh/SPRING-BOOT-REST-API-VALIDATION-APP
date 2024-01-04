package com.ravi.service;

import java.util.List;

import com.ravi.request.UserRequest;
import com.ravi.response.UserResponse;

public interface IUserService {

	public UserResponse saveUser(UserRequest request);

	public List<UserResponse> getUsers();

	public UserResponse getUser(Integer userId);
}

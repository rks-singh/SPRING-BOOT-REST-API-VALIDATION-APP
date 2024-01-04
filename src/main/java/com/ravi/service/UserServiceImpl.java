package com.ravi.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ravi.entity.User;
import com.ravi.exception.UserNotFoundException;
import com.ravi.repository.UserRepository;
import com.ravi.request.UserRequest;
import com.ravi.response.UserResponse;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserResponse saveUser(UserRequest request) {
		User user = new User();
		BeanUtils.copyProperties(request, user);
		User userResponse = userRepository.save(user);

		UserResponse response = new UserResponse();
		BeanUtils.copyProperties(userResponse, response);

		return response;
	}

	@Override
	public List<UserResponse> getUsers() {
		List<UserResponse> userResponses = new ArrayList<>();
		List<User> users = userRepository.findAll();
		for (User user : users) {
			UserResponse response = new UserResponse();
			BeanUtils.copyProperties(user, response);
			userResponses.add(response);
		}
		System.out.println(userResponses);
		return userResponses;
	}

	@Override
	public UserResponse getUser(Integer userId){
		UserResponse userResponse = new UserResponse();
		User user = null;
		Optional<User> byId = userRepository.findById(userId);
		if(byId.isPresent()) {
			 user = byId.get();
		}
		if(user!=null) {
			BeanUtils.copyProperties(user, userResponse);
			return userResponse;
		}else {
			throw new UserNotFoundException("User not found with given id: "+userId);
		}
	}

}

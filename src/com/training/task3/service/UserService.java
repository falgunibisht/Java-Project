package com.training.task3.service;

import java.util.Optional;

import com.training.task3.dto.UserDto;

public interface UserService {


	public Optional<UserDto> getUser(String id);
	
	public void addUser(UserDto u);
	
	public void updateUser(UserDto u);
	
	public void deleteUser(String id);
}

package com.training.task3.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.task3.converter.UserConverter;
import com.training.task3.dao.Dao;
import com.training.task3.dto.UserDto;
import com.training.task3.entity.User;

@Service
//@ComponentScan("com.training.task3.converter")
public class UserServiceImpl implements UserService{

	@Autowired
	private Dao dao;
	
	@Autowired
	private UserConverter userConverter; 

	

	@Override
	public void addUser(UserDto u) {
		// TODO Auto-generated method stub
		User user=userConverter.dtoToEntity(u);
		dao.save(user);
	}

	@Override
	public void updateUser(UserDto u) {
		// TODO Auto-generated method stub
		User user=userConverter.dtoToEntity(u);
		dao.save(user);
	}

	@Override
	public Optional<UserDto> getUser(String id) {
		// TODO Auto-generated method stub
		User user=dao.findById(id).orElse(null);
		
		return Optional.ofNullable(userConverter.entityToDto(user));
	}

	@Override
	public void deleteUser(String id) {
		// TODO Auto-generated method stub	
		System.out.println("Here");
	    dao.deleteById(id);
	}
}

	
	
	
	



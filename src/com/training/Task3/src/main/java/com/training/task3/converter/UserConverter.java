package com.training.task3.converter;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.training.task3.dto.UserDto;
import com.training.task3.entity.User;

@Service
@Component
public class UserConverter {

	public  UserDto entityToDto(User user)
	{
//		UserDto dto=new UserDto();
//		
//		dto.setId(user.getId());
//		dto.setFirstname(user.getFirstname());
//		dto.setSecondname(user.getSecondname());
//		dto.setAge(user.getAge());
//		dto.setSalary(user.getSalary());
//		
//		return dto;
		
		ModelMapper mapper = new ModelMapper();
		return(mapper.map(user, UserDto.class));
	}
	
	public User dtoToEntity(UserDto dto)
	{
//		User user=new User();
//		
//		user.setId(dto.getId());
//		user.setFirstname(dto.getFirstname());
//		user.setSecondname(dto.getSecondname());
//		user.setAge(dto.getAge());
//		user.setSalary(dto.getSalary());
//		
//		return user;
		
		ModelMapper mapper = new ModelMapper();
		return(mapper.map(dto, User.class));
	}
}

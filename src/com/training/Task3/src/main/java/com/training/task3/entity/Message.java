package com.training.task3.entity;

import javax.validation.constraints.NotEmpty;

import com.training.task3.dto.UserDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Message {
	
	@NotEmpty(message="action cannot be empty")
	public String action;
	
	public UserDto userDto;
	

}

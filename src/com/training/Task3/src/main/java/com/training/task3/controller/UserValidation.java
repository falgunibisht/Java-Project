package com.training.task3.controller;

import com.training.task3.dto.UserDto;

public class UserValidation{

	public boolean check(UserDto userDto)
	{
		boolean ans=true;
		if (userDto.getFirstname().equals("")|| userDto.getSecondname().equals("")|| userDto.getAge()<18)
			ans= false;
		return ans;
	}
}



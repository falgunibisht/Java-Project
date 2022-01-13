package com.training.task3.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection="Users")
public class User {

	@Id
	private String id;
	
	private String firstname;
	
	private String secondname;
	
	private int  age;
	
	private int salary;
}

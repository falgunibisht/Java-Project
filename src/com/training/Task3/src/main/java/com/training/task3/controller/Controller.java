package com.training.task3.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.training.task3.dto.UserDto;
import com.training.task3.entity.Message;
import com.training.task3.service.UserService;


@RestController
public class Controller {
	
	Logger logger= LoggerFactory.getLogger(Controller.class);
	
	@Autowired
	private UserService userService;
	
	
	UserValidation userValidation = new UserValidation();
	
	@Autowired
	KafkaTemplate<String, Object> kafkaTemplate;
	
	private final String topic="Kafka_Project";
	
	@PostMapping("/addUser")
	public ResponseEntity<UserDto> addUser(@RequestBody @Valid Message m)
	{
		if(userValidation.check(m.userDto))
		{
			//System.out.println(("in"));
			try {
				kafkaTemplate.send(topic, m);
				logger.info("User Added");
				return new ResponseEntity<UserDto>(m.userDto,HttpStatus.ACCEPTED);
			} catch(Exception e) {
				return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
			}
		}
		return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
	}
	
	
	@GetMapping("getUser/{id}")
	public Optional<UserDto> getUser(@PathVariable String id)
	{
		logger.info("User Fetched");
		return userService.getUser(id);
	}
	
	
	@PutMapping("/updateUser")
	public ResponseEntity<UserDto> updateUser(@RequestBody @Valid Message m)
	{
		if(userValidation.check(m.userDto))
		{
			//System.out.println("in");
			try {
				kafkaTemplate.send(topic,m);
				logger.info("User Updated");
				return new ResponseEntity<UserDto>(m.userDto,HttpStatus.ACCEPTED);
			} catch (Exception e) {
				return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
		return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
	
	
	@DeleteMapping("/deleteUser/{id}")
	public ResponseEntity<HttpStatus> deleteUser(@PathVariable String id) 
	{
		try {
			logger.info("User Deleted");
//			Message m=new Message();
//			UserDto userDto=new UserDto();
//			m.setAction("Delete");
//			userDto.setId(id);
//			m.userDto=userDto;
//			kafkaTemplate.send(topic,m);
			return new ResponseEntity<HttpStatus>(HttpStatus.ACCEPTED);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
//		try {
//			Optional<User> customer = dao.findById(id);
//			if (customer.isPresent()) {
//				dao.delete(customer.get());
//				return new ResponseEntity<HttpStatus>(HttpStatus.ACCEPTED);
//			}
//			return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
//		} catch (Exception e) {
//			return new ResponseEntity<HttpStatus>(HttpStatus.INTERNAL_SERVER_ERROR);
//		}
	}

}

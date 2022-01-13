package com.training.task3.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.training.task3.entity.Message;
import com.training.task3.service.UserService;

@Service
@Component
public class Consumer {

	@Autowired
	public UserService userService;
	
	
//	@KafkaListener(groupId="Kafka_Project-1", topics="Kafka_Project",containerFactory="kafkaListenerContainerFactory")
//	public void getFromTopic(String id)
//	{
//		userService.deleteUser(id);
//		//System.out.println("here");
//	
//	}
	@KafkaListener(groupId="Kafka_Project-2", topics="Kafka_Project",containerFactory="userKafkaListenerContainerFactory")
	public void getUserFromTopic(Message m)
	{
		if (m.action.equals("Add"))
			userService.addUser(m.userDto);

		
		if (m.action.equals("Update"))
			userService.updateUser(m.userDto);
		
		if (m.action.equals("Delete"))
		{
			System.out.println("Jere");
			userService.deleteUser(m.userDto.getId());
		}
	}
	
	
}

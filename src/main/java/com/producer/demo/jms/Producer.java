package com.producer.demo.jms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.producer.demo.model.Person;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class Producer {
	
	@Autowired
	JmsTemplate jmsTemplate;
	
	@Value("${activemq.name}")
	private String destinationQueue;
	
	public void send(Person person) {
		Gson gson = new Gson();
		String jsonPerson = gson.toJson(person);
		jmsTemplate.convertAndSend(destinationQueue, jsonPerson);
	}
	
}

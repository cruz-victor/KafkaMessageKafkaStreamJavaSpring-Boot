package com.vic.kafka.app.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vic.kafka.app.entity.Commodity;

//@Service
public class CommodityNotificationConsumer {
	
	private ObjectMapper objectMapper=new ObjectMapper();
	
	private static final Logger log=LoggerFactory.getLogger(CommodityNotificationConsumer.class);

	@KafkaListener(topics = "t_commodity", groupId = "cg-notification")
	public void consume(String message) throws JsonMappingException, JsonProcessingException {
		var commodity=objectMapper.readValue(message, Commodity.class);
		log.info("Notificacion logic for {}", commodity);
	}
}

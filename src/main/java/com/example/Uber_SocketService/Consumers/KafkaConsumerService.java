package com.example.Uber_SocketService.Consumers;

import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.KafkaListeners;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {

 @KafkaListener(topics = "sample-topic")
    public void listen(String message){
     System.out.println(message);
 }
}

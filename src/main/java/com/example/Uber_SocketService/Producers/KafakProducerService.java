package com.example.Uber_SocketService.Producers;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafakProducerService {

private  final KafkaTemplate<String,String> kafkaTemplate;
    public KafakProducerService ( KafkaTemplate<String, String> kafkaTemplate) {

        this.kafkaTemplate = kafkaTemplate;
    }

    public void publishMessage(String topic ,String message){
        kafkaTemplate.send(topic,message);
    }
}

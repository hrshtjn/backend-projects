package com.demo.kafkapoc.service;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {

    private final String GROUP_ID = "quotes-consumer-group";

    private static final String TOPIC="demo";

    //TODO - uncomment the below line to start listener
    @KafkaListener(topics = TOPIC,groupId = GROUP_ID)
    public void listen(ConsumerRecord<String, String> record) {
        System.out.println("Received Message:");
        System.out.println("Key: " + record.key());
        System.out.println("Value: " + record.value());
    }
}

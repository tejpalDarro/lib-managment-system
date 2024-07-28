package com.phenol.endpoints.kafkaController;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class kafkaConsumer {

    @KafkaListener(topics = "amdocs.network.libmanagment.books", groupId = "book-consumer-group")
    public void consume(String message) {
        System.out.println("Consmed message: " + message);
    }
}

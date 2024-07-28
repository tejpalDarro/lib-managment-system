package com.phenol.transactionEndpoints.kafkaEndpoints;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {
    @KafkaListener(topics = "amdocs.netwrok.libmanagement.transactions", groupId = "transactions-consumer-group")
    public void consume(String message) {
        System.out.println("Consumed message: " + message);
    }
}

package com.phenol.TransactionService.kafkaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaTransactionProducer {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    private final String topic = "amdocs.netwrok.libmanagement.transactions";

    public void sendMessage(String message) {
        kafkaTemplate.send(topic, message);
    }
}

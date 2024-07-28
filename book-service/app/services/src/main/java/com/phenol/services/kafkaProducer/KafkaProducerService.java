package com.phenol.services.kafkaProducer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducerService {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    private final String topic = "amdocs.network.libmanagement.books";

    public void sendMessage(String message) {
        kafkaTemplate.send(topic, message);
    }
}

package com.phenol.notificationKafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class NotificationKafkaConsumer {
    @KafkaListener(topics = "amdocs.network.libmanagement.transactions.notification", groupId = "my-group")
    public void listen(String message) {
        System.out.println("Received message: " + message);
    }
}

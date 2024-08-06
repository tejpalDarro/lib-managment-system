package com.phenol.TransactionService.kafkaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class KafkaTransactionProducer {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    private final String topic = "amdocs.network.libmanagement.transactions";
    private final String notificationTopic = "amdocs.network.libmanagement.transactions.notification";

    public void sendMessage(String message) {
        CompletableFuture<SendResult<String, String>> future =  kafkaTemplate.send(topic, message);
        future.whenComplete((res, ex) -> {
            if (ex == null) {
                System.out.println("Success!");
            } else {
                System.out.println("failure!");
            }
        });

    }

    public void sendMessageToNotification(String message) {
        CompletableFuture<SendResult<String, String>> future =  kafkaTemplate.send(notificationTopic, message);
        future.whenComplete((res, ex) -> {
            if (ex == null) {
                System.out.println("Success!");
            } else {
                System.out.println("failure!");
            }
        });

    }
}

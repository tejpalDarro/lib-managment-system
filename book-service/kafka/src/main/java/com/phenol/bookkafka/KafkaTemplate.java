package com.phenol.bookkafka;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KafkaTemplate {
    @Bean
    public KafkaTemplate kafkaTemplate() {
        return new KafkaTemplate();
    }
}

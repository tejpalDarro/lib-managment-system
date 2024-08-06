package org.example;

import org.kafkaconfiguration.KafkaConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackageClasses = { KafkaConfig.class})
public class KafkaMainApplication {
    public static void main(String[] args) {
        SpringApplication.run(KafkaMainApplication.class, args);
    }
}
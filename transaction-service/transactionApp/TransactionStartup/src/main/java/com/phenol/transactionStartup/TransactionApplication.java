package com.phenol.transactionStartup;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = {com.phenol.transactionRepository.TransactionRepository.class})
@EntityScan(basePackageClasses = {com.phenol.transactionRepository.TransactionRepository.class, com.phenol.transactionDomain.TransactionEntity.Transactions.class})
@ComponentScan(basePackageClasses = {com.phenol.transactionEndpoints.TransactionController.class, com.phenol.TransactionService.TransactionServices.class})
public class TransactionApplication {
    public static void main(String[] args) {
        SpringApplication.run(TransactionApplication.class, args);
    }

    @Bean
    @LoadBalanced
    public RestTemplate getTemplate() {
        return new RestTemplate();
    }
}

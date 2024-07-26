package com.phenol.transactionStartup;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = {com.phenol.transactionRepository.TransactionRepository.class})
@EntityScan(basePackageClasses = {com.phenol.transactionRepository.TransactionRepository.class, com.phenol.transactionDomain.TransactionEntity.Transactions.class})
public class TransactionApplication {
    public static void main(String[] args) {
        SpringApplication.run(TransactionApplication.class, args);
    }
}

package com.phenol.bookservice.Entity;

import org.h2.tools.Server;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = {LibRepository.class})
@EntityScan(basePackageClasses = {com.phenol.bookservice.Entity.Books.class})
@ComponentScan(basePackageClasses = {com.phenol.endpoints.restController.bookController.class, com.phenol.services.BookServices.class})
public class BookApplication {

    @Autowired
    private LibRepository repo;

    public static void main(String[] args) {
        SpringApplication.run(BookApplication.class, args);
    }
    @Bean(initMethod = "start", destroyMethod = "stop")
    public Server inMemoryH2DatabaseaServer() throws SQLException {
        return Server.createTcpServer(
                "-tcp", "-tcpAllowOthers", "-tcpPort", "9090");
    }

    @Bean
    @LoadBalanced
    public RestTemplate getTemplate() {
        return new RestTemplate();
    }

    @Bean
    public CommandLineRunner loadData() {
        return args -> {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.registerModule(new JavaTimeModule());  
            try {
                // Load JSON file from resources
                List<Books> books = objectMapper.readValue(
                    new ClassPathResource("books.json").getFile(),
                    new TypeReference<List<Books>>(){}
                );

                // Save books to the database
                repo.saveAll(books);
            } catch (IOException e) {
                e.printStackTrace();
            }
        };
    }
}

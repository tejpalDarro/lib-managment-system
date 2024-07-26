package com.phenol.libuserservice;

import jakarta.persistence.Entity;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackageClasses = {com.phenol.libuserservice.LibUserEntity.class})
@EnableJpaRepositories(basePackageClasses = {com.phenol.libuserservice.UserRepository.class})
@ComponentScan(basePackageClasses = {com.phenol.libuserservice.UserRepository.class, com.phenol.libuserservice.LibUserEntity.class})
public class UserApplication {
    public static void main(String[] args) {
        SpringApplication.run(UserApplication.class, args);
    }
}

package org.phenol.notificationStartup;

import org.phenol.notificationDomain.NoficationEntity;
import org.phenol.notificationRepo.NotificationRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = {NotificationRepository.class})
@EntityScan(basePackageClasses = {NoficationEntity.class})
@ComponentScan(basePackageClasses = {org.phenol.notificationDomain.NotificationController.class,
        org.phenol.notificationService.NotificationService.class,
        org.phenol.mapper.NotificationMapper.class,
        com.phenol.notificationKafka.NotificationKafkaConsumer.class})
public class NotificationMainApplication {
    public static void main(String[] args) {
        SpringApplication.run(NotificationMainApplication.class, args);
    }
}

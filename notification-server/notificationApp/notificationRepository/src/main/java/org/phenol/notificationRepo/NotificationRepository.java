package org.phenol.notificationRepo;

import org.phenol.notificationDomain.NoficationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotificationRepository extends JpaRepository<NoficationEntity, Long> {
}

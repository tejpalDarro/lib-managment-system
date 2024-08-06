package org.phenol.notificationService;

import org.phenol.notificationDomain.NoficationEntity;
import org.phenol.notificationDomain.NotificationDTO;

public interface NotificationService {
    NotificationDTO createNotification(NoficationEntity e);

    NotificationDTO createWithFields(Long userId, Long bookId, String date, String type);
}

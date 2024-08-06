package org.phenol.notificationService;

import org.phenol.notificationDomain.NoficationEntity;
import org.phenol.notificationDomain.NotificationDTO;
import org.phenol.notificationDomain.Type;

public interface NotificationService {
    NotificationDTO createNotification(NoficationEntity e);

    NotificationDTO createWithFields(Long userId, Long bookId, String date, String type);

    NotificationDTO createNotificationWithFields(Long userId, Long bookId, Type type);
}

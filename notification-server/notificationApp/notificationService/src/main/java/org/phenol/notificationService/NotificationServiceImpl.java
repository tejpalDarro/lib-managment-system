package org.phenol.notificationService;

import org.phenol.mapper.NotificationMapper;
import org.phenol.notificationDomain.NoficationEntity;
import org.phenol.notificationDomain.NotificationDTO;
import org.phenol.notificationDomain.Type;
import org.phenol.notificationRepo.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;

@Service
public class NotificationServiceImpl implements NotificationService{

    @Autowired
    private NotificationMapper mapper;

    @Autowired
    private NotificationRepository notificationRepository;

    @Override
    public NotificationDTO createNotification(NoficationEntity e) {
        NoficationEntity save = notificationRepository.save(e);
        return mapper.getDTO(save);
    }

    @Override
    public NotificationDTO createWithFields(Long userId, Long bookId, String date, String type) {
        NoficationEntity e = new NoficationEntity();
        e.setUserId(userId);
        e.setBookId(bookId);
        e.setType(Type.valueOf(type));
        e.setCreatedAt(LocalDate.parse(date));
        NoficationEntity save = notificationRepository.save(e);
        return mapper.getDTO(save);
    }

    @Override
    public NotificationDTO createNotificationWithFields(Long userId, Long bookId, Type type) {
        NoficationEntity e = new NoficationEntity();
        e.setType(type);
        e.setBookId(bookId);
        e.setUserId(userId);
        e.setCreatedAt(LocalDate.now());
        notificationRepository.save(e);
        return mapper.getDTO(e);
    }
}

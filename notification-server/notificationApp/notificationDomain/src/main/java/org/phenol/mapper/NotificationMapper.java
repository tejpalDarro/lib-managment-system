package org.phenol.mapper;


import org.phenol.notificationDomain.NoficationEntity;
import org.phenol.notificationDomain.NotificationDTO;
import org.springframework.stereotype.Service;

@Service
public class NotificationMapper {


    public NotificationDTO getDTO(NoficationEntity e) {
        NotificationDTO dto = new NotificationDTO();
        dto.setId(e.getId());
        dto.setType(e.getType());
        dto.setBookId(e.getBookId());
        dto.setCreatedAt(e.getCreatedAt());
        dto.setUserId(e.getUserId());
        return dto;
    }
}

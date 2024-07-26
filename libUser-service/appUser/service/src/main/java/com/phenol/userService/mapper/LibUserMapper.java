package com.phenol.userService.mapper;

import com.phenol.libuserservice.LibUserEntity;
import com.phenol.libuserservice.dto.LibUserDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibUserMapper {

    public List<LibUserDTO> toListDto(List<LibUserEntity> entity) {
        return entity.stream().map(LibUserMapper::toDTO).toList();
    }

    public static LibUserDTO toDTO(LibUserEntity entity) {
        LibUserDTO dto = new LibUserDTO();
        dto.setId(entity.getId());
        dto.setUsername(entity.getUsername());
        dto.setEmail(entity.getEmail());
        dto.setCreationDate(entity.getCreationDate());
        dto.setRoles(entity.getRoles());
        return dto;
    }
}

package com.phenol.userService.impl;

import com.phenol.libuserservice.LibUserEntity;
import com.phenol.libuserservice.UserRepository;
import com.phenol.libuserservice.dto.LibUserDTO;
import com.phenol.userService.UserServices;
import com.phenol.userService.mapper.LibUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserServices {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private LibUserMapper mapper;

    @Override
    public List<LibUserDTO> getAllUsers() {
        List<LibUserEntity> all = userRepository.findAll();
        return mapper.toListDto(all);
    }

    @Override
    public LibUserDTO createUser(LibUserEntity user) {
        LibUserEntity save = userRepository.save(user);
        return LibUserMapper.toDTO(save);
    }

    @Override
    public void deleteById(Long id) {
        userRepository.findById(id).orElseThrow(() -> new RuntimeException("User Not Found"));
        userRepository.deleteById(id);
    }

}

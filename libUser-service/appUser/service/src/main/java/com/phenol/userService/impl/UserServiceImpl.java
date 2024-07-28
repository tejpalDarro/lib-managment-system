package com.phenol.userService.impl;

import com.phenol.bookservice.Entity.Books;
import com.phenol.bookservice.dto.BookDTO;
import com.phenol.libuserservice.LibUserEntity;
import com.phenol.libuserservice.UserRepository;
import com.phenol.libuserservice.dto.LibUserDTO;
import com.phenol.transactionDomain.com.phenol.transactionDomain.TransactionDTO;
import com.phenol.userService.UserServices;
import com.phenol.userService.mapper.LibUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class UserServiceImpl implements UserServices {

    @Autowired
    private RestTemplate restTemplate;

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

    @Override
    public List<BookDTO> getBooksById(List<Integer> ids) {
        String url = "http://localhost:8080/books/";
        restTemplate.getForObject(url, BookDTO.class);
        return null;
    }
//
//    @Override
//    public ResponseEntity<TransactionDTO> createBorrowBook(Long id) {
//        // check the book
//        String bookUrl = "http://localhost:8080/books/" + id;
//        String transactionUrl = "http://localhost:8080/tran/" + id;
//        ResponseEntity<BookDTO> forEntity = restTemplate.getForEntity(bookUrl, BookDTO.class);
//        if (!forEntity.getStatusCode().is2xxSuccessful()) {
//            return ResponseEntity.notFound().build();
//        }
//        //restTemplate.getForObject()
//        return ResponseEntity.ok(TransactionDTO);
//
//
//        // get the transaction
//    }


}

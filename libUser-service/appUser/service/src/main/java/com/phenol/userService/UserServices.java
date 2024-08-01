package com.phenol.userService;

import com.phenol.libuserservice.LibUserEntity;
import com.phenol.libuserservice.dto.LibUserDTO;

import java.util.List;

public interface UserServices {
    List<LibUserDTO> getAllUsers();


    LibUserDTO createUser(LibUserEntity user);

    void deleteById(Long id);

//    List<BookDTO> getBooksById(List<Integer> ids);

    //ResponseEntity<TransactionDTO> createBorrowBook(Long id);
}

package com.phenol.userService;

import com.phenol.bookservice.dto.BookDTO;
import com.phenol.libuserservice.LibUserEntity;
import com.phenol.libuserservice.dto.LibUserDTO;
import com.phenol.transactionDomain.com.phenol.transactionDomain.TransactionDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserServices {
    List<LibUserDTO> getAllUsers();


    LibUserDTO createUser(LibUserEntity user);

    void deleteById(Long id);

    List<BookDTO> getBooksById(List<Integer> ids);

    //ResponseEntity<TransactionDTO> createBorrowBook(Long id);
}

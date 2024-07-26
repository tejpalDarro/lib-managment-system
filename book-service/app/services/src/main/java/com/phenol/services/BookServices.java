package com.phenol.services;

import com.phenol.bookservice.Entity.Books;
import com.phenol.bookservice.dto.BookDTO;

import java.util.List;

public interface BookServices {
    BookDTO createBook(Books book);

    List<BookDTO> getAllBooks();

    BookDTO updateBook(Books book) throws Exception;

    void deleteBook(int id) throws Exception;

    //List<BookDTO> getAllBooksByYear(int year);

    List<BookDTO> getAllBooksByAuthor(String authorName);

    List<BookDTO> getAllBooksByTitle(String title);
}

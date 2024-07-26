package com.phenol.services.impl;

import com.phenol.bookservice.Entity.Books;
import com.phenol.bookservice.dto.BookDTO;
import com.phenol.bookservice.Entity.LibRepository;
import com.phenol.services.BookServices;
import com.phenol.services.mapper.BookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookServices {

    @Autowired
    private LibRepository libRepository;

    @Autowired
    private BookMapper bookMapper;

    @Override
    public BookDTO createBook(Books book) {
        Books save = libRepository.save(book);
        return bookMapper.toDto(save);
    }

    @Override
    public List<BookDTO> getAllBooks() {
        List<Books> all = libRepository.findAll();
        return bookMapper.toListDto(all);
    }

    @Override
    public BookDTO updateBook(Books book) throws Exception {
        Books user = libRepository.findById(book.getBookId()).orElseThrow(() -> new Exception("user Not found"));
        return new BookDTO();
    }

    @Override
    public void deleteBook(int id) throws Exception {
        Books user = libRepository.findById(id).orElseThrow(() -> new Exception("user Not found"));
        if (user != null) {
            libRepository.deleteById(id);
            return;
        }

    }

    @Override
    public List<BookDTO> getAllBooksByYear(int year) {
        List<Books> byYear = libRepository.findByYear(year);
        return bookMapper.toListDto(byYear);
    }

    @Override
    public List<BookDTO> getAllBooksByAuthor(String authorName) {
        List<Books> byAuthorName = libRepository.findByAuthorName(authorName);
        return bookMapper.toListDto(byAuthorName);
    }

    @Override
    public List<BookDTO> getAllBooksByTitle(String title) {
        List<Books> byTitle = libRepository.findByTitle(title);
        return bookMapper.toListDto(byTitle);
    }


}

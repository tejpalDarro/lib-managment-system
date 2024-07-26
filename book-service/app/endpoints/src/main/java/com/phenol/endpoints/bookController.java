package com.phenol.endpoints;

import com.phenol.bookservice.Entity.Books;
import com.phenol.bookservice.dto.BookDTO;
import com.phenol.services.BookServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class bookController {

    @Autowired
    private BookServices bookServices;

    // testing the get request
    @GetMapping("/test")
    public String test() {
        return "Hello! ";
    }

    // Book CRUD

    @GetMapping("/all")
    public List<BookDTO> getAllBooks() {
        return bookServices.getAllBooks();
    }

    @PostMapping("/create")
    public BookDTO createBook(@RequestBody Books book) {
        return bookServices.createBook(book);
    }

    @PutMapping("/put")
    public ResponseEntity<BookDTO> putBook(@RequestBody Books book) throws Exception {
        BookDTO bookDTO = bookServices.updateBook(book);
        return ResponseEntity.ok(bookDTO);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteBook(@PathVariable int id) throws Exception {
        bookServices.deleteBook(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    // Search related CRUD

    @GetMapping("/get/year/{year}")
    public ResponseEntity<List<BookDTO>> getBookByYear(@PathVariable int year) throws Exception {
        List<BookDTO> allBooksByYear = bookServices.getAllBooksByYear(year);
        return ResponseEntity.ok(allBooksByYear);
    }

    @GetMapping("/get/author/{authorName}")
    public ResponseEntity<List<BookDTO>> getBookByAuthor(@PathVariable String authorName) throws Exception {
        List<BookDTO> allBooksByYear = bookServices.getAllBooksByAuthor(authorName);
        return ResponseEntity.ok(allBooksByYear);
    }

    @GetMapping("/get/title/{title}")
    public ResponseEntity<List<BookDTO>> getBookByTitle(@PathVariable String title) throws Exception {
        List<BookDTO> allBooksByYear = bookServices.getAllBooksByTitle(title);
        return ResponseEntity.ok(allBooksByYear);
    }



}

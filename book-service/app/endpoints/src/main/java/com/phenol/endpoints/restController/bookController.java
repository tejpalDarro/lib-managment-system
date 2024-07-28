package com.phenol.endpoints.restController;

import com.phenol.bookservice.Entity.Books;
import com.phenol.bookservice.dto.BookDTO;
import com.phenol.services.BookServices;
import com.phenol.services.kafkaProducer.KafkaProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Book;
import java.util.List;

@RestController
@RequestMapping("/books")
public class bookController {

    @Autowired
    private BookServices bookServices;

    @Autowired
    private KafkaProducerService kafkaProducerService;

    // testing the get request
    @GetMapping("/test")
    public String test() {
        return "Hello! ";
    }

    // Book CRUD

    @GetMapping("/all")
    public ResponseEntity<List<BookDTO>> getAllBooks() {
        List<BookDTO> allBooks = bookServices.getAllBooks();
        kafkaProducerService.sendMessage("Retrieved all books");
        return ResponseEntity.ok(allBooks);
    }

    @PostMapping("/create")
    public ResponseEntity<BookDTO> createBook(@RequestBody Books book) {
        BookDTO dto = bookServices.createBook(book);
        kafkaProducerService.sendMessage("Created new book" + dto.getTitle());
        return ResponseEntity.ok(dto);
    }

    @PutMapping("/put")
    public ResponseEntity<BookDTO> putBook(@RequestBody Books book) {
        try {
            BookDTO bookDTO = bookServices.updateBook(book);
            kafkaProducerService.sendMessage("Updated new book" + bookDTO.getTitle());
            return ResponseEntity.ok(bookDTO);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable int id)  {
        try {
            bookServices.deleteBook(id);
            kafkaProducerService.sendMessage("Deleted Book" + id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    // Search related CRUD

//    @GetMapping("/get/year/{year}")
//    public ResponseEntity<List<BookDTO>> getBookByYear(@PathVariable int year) throws Exception {
//        List<BookDTO> allBooksByYear = bookServices.getAllBooksByYear(year);
//        return ResponseEntity.ok(allBooksByYear);
//    }

    @GetMapping("/get/author/{authorName}")
    public ResponseEntity<List<BookDTO>> getBookByAuthor(@PathVariable String authorName) {
        try {
            List<BookDTO> allBooksByYear = bookServices.getAllBooksByAuthor(authorName);
            kafkaProducerService.sendMessage("Retrieved all books by " + authorName);
            return ResponseEntity.ok(allBooksByYear);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping("/get/title/{title}")
    public ResponseEntity<List<BookDTO>> getBookByTitle(@PathVariable String title) {
        try {
            List<BookDTO> allBooksByYear = bookServices.getAllBooksByTitle(title);
            kafkaProducerService.sendMessage("Retrieved all books by " + title);
            return ResponseEntity.ok(allBooksByYear);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }



}

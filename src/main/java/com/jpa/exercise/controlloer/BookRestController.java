package com.jpa.exercise.controlloer;

import com.jpa.exercise.domain.Book;
import com.jpa.exercise.domain.BookDTO;
import com.jpa.exercise.repository.BookRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/book")
public class BookRestController {

    private final BookRepository bookRepository;

    public BookRestController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @GetMapping("/list")
    public ResponseEntity<List<Book>> getList() {
        List<Book> all = bookRepository.findAll();
        return ResponseEntity.ok().body(all);
    }
}

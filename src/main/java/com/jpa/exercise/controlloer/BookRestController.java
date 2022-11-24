package com.jpa.exercise.controlloer;

import com.jpa.exercise.domain.dto.BookDTO;
import com.jpa.exercise.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/book")
public class BookRestController {

    private final BookService bookService;

    public BookRestController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/list")
    public ResponseEntity<List<BookDTO>> getList() {
        List<BookDTO> bookDTOS = bookService.bookList();
        return ResponseEntity.ok().body(bookDTOS);
    }
}

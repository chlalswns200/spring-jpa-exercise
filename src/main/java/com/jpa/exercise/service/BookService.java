package com.jpa.exercise.service;

import com.jpa.exercise.domain.Book;
import com.jpa.exercise.domain.dto.BookDTO;
import com.jpa.exercise.repository.AuthorRepository;
import com.jpa.exercise.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository, AuthorRepository archRepository) {
        this.bookRepository = bookRepository;
    }

    public List<BookDTO> bookList() {
        List<Book> all = bookRepository.findAll();

        List<BookDTO> allbooks = new ArrayList<>();
        for (Book book : all) {
            allbooks.add(new BookDTO(book.getId(),book.getName(),book.getAuthor().getName(),book.getPublisher().getName()));
        }
        return allbooks;
    }


}

package com.jpa.exercise.service;

import com.jpa.exercise.domain.Author;
import com.jpa.exercise.domain.Book;
import com.jpa.exercise.domain.BookDTO;
import com.jpa.exercise.repository.AuthorRepository;
import com.jpa.exercise.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    private final BookRepository bookRepository;
    private final AuthorRepository archRepository;

    public BookService(BookRepository bookRepository, AuthorRepository archRepository) {
        this.bookRepository = bookRepository;
        this.archRepository = archRepository;
    }

    public List<BookDTO> bookList() {
        List<Book> all = bookRepository.findAll();

        List<BookDTO> allbooks = new ArrayList<>();
        for (Book book : all) {
            Optional<Author> byId = archRepository.findById(Long.parseLong(book.getAuthorId()));
            allbooks.add(new BookDTO(book.getId(),book.getName(),byId.get().getName()));
        }
        return allbooks;
    }


}

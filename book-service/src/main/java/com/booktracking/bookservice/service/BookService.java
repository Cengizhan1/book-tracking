package com.booktracking.bookservice.service;

import com.booktracking.bookservice.dto.BookDto;
import com.booktracking.bookservice.dto.BookIdDto;
import com.booktracking.bookservice.exception.BookNotFoundException;
import com.booktracking.bookservice.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    private final BookRepository repository;

    public BookService(BookRepository repository) {
        this.repository = repository;
    }

    public List<BookDto> getAllBooks() {
        return repository.findAll()
                .stream()
                .map(BookDto::convert).toList();
    }

    public BookIdDto findByIsbn(String isbn) {
        return  repository.findByIsbn(isbn)
                .map(BookIdDto::convert)
                .orElseThrow(() -> new BookNotFoundException("Book could not be found by ISBN: " + isbn));
    }

    public BookDto findBookDetails(String id) {
        return repository.findById(id)
                .map(BookDto::convert)
                .orElseThrow(() -> new BookNotFoundException("Book could not be found by ID: " + id));
    }
}

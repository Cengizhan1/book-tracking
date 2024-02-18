package com.booktracking.bookservice.controller;

import com.booktracking.bookservice.dto.BookDto;
import com.booktracking.bookservice.dto.BookIdDto;
import com.booktracking.bookservice.service.BookService;
import jakarta.validation.constraints.NotEmpty;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/api/book")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public ResponseEntity<List<BookDto>> getAllBooks() {
        return ResponseEntity.ok(bookService.getAllBooks());
    }

    @GetMapping("/isbn/{isbn}")
    public ResponseEntity<BookIdDto> findByIsbn(@PathVariable @NotEmpty String isbn) {
        return ResponseEntity.ok(bookService.findByIsbn(isbn));
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookDto> findBookDetails(@PathVariable @NotEmpty String id) {
        return ResponseEntity.ok(bookService.findBookDetails(id));
    }
}

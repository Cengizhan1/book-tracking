package com.booktracking.bookservice.repository;

import com.booktracking.bookservice.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, String> {

    Optional<Book> findByIsbn(String isbn);
}

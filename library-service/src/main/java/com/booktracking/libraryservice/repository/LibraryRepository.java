package com.booktracking.libraryservice.repository;

import com.booktracking.libraryservice.model.Library;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibraryRepository extends JpaRepository<Library, String> {
}

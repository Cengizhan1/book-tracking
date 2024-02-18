package com.booktracking.libraryservice.controller;

import com.booktracking.libraryservice.dto.AddBookRequest;
import com.booktracking.libraryservice.dto.LibraryDto;
import com.booktracking.libraryservice.service.LibraryService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RefreshScope
@RequestMapping("/v1/api/library")
public class LibraryController {
    private final LibraryService libraryService;

//    @Value("${library-service.count}")
//    private Integer count;

    public LibraryController(LibraryService libraryService) {
        this.libraryService = libraryService;
    }

    @GetMapping("{id}")
    public ResponseEntity<LibraryDto> getLibraryById(@PathVariable String id) {
        return ResponseEntity.ok(libraryService.getAlBooksInLibraryById(id));
    }

    @PostMapping
    public ResponseEntity<LibraryDto> createLibrary() {
        return ResponseEntity.ok(libraryService.createLibrary());
    }

    @PutMapping
    public ResponseEntity<Void> addBookToLibrary(@RequestBody AddBookRequest request) {
            libraryService.addBookToLibrary(request);
            return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<String>> getAllLibraries() {
        return ResponseEntity.ok(libraryService.getAllLibraries());
    }

//    @GetMapping("/count")
//    public ResponseEntity<String> getCount() {
//        return ResponseEntity.ok("Library count is" + count);
//    }
}

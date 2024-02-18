package com.booktracking.libraryservice.service;

import com.booktracking.libraryservice.client.BookServiceClient;
import com.booktracking.libraryservice.dto.AddBookRequest;
import com.booktracking.libraryservice.dto.LibraryDto;
import com.booktracking.libraryservice.exception.LibraryNotFoundException;
import com.booktracking.libraryservice.model.Library;
import com.booktracking.libraryservice.repository.LibraryRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LibraryService {

    private final LibraryRepository libraryRepository;
    private final BookServiceClient bookServiceClient;

    public LibraryService(LibraryRepository libraryRepository, BookServiceClient bookServiceClient) {
        this.libraryRepository = libraryRepository;
        this.bookServiceClient = bookServiceClient;
    }

    public LibraryDto getAlBooksInLibraryById(String id) {
        Library library = libraryRepository.findById(id)
                .orElseThrow(() -> new LibraryNotFoundException("Library could not found by id: " + id));
        return new LibraryDto(library.getId(),
                library.getUserBook()
                        .stream()
                        .map(bookServiceClient::getBookById) // feign
                        .map(ResponseEntity::getBody)
                        .toList());
    }

    public LibraryDto createLibrary() {
        Library newLibrary = libraryRepository.save(new Library());
        return new LibraryDto(newLibrary.getId(), null);
    }

    public void addBookToLibrary(AddBookRequest request){
        String bookId = bookServiceClient.getBookByIsbn(request.isbn()).getBody().isbn();

        Library library = libraryRepository.findById(request.id())
                .orElseThrow(() -> new LibraryNotFoundException("Library could not found by id: " + request.id()));
        library.getUserBook().add(bookId);

        libraryRepository.save(library);
    }

    public List<String> getAllLibraries() {
        return libraryRepository.findAll()
                .stream()
                .map(Library::getId)
                .toList();
    }
}
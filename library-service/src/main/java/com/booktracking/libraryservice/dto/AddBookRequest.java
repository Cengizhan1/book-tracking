package com.booktracking.libraryservice.dto;

public record AddBookRequest(
        String id,
        String isbn
) {}

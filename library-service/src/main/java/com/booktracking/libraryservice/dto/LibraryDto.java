package com.booktracking.libraryservice.dto;

import jakarta.annotation.Nullable;

import java.util.List;

public record LibraryDto(
    String id,
    @Nullable
    List<BookDto> userBookList
) {}

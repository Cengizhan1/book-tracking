package com.booktracking.libraryservice.dto;

public record BookDto(
    BookIdDto bookIdDto,
    String title,
    Integer year,
    String author,
    String pressName
) {
}

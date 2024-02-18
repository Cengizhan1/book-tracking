package com.booktracking.bookservice.dto;

import com.booktracking.bookservice.model.Book;
import jakarta.annotation.Nullable;

public record BookDto(
        @Nullable
        String id,
        String title,
        Integer bookYear,
        String author,
        String pressName,
        String isbn
) {

    public static BookDto convert(Book book) {
        return new BookDto(
                book.getId(),
                book.getTitle(),
                book.getBookYear(),
                book.getAuthor(),
                book.getPressName(),
                book.getIsbn());
    }
}

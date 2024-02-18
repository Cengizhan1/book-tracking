package com.booktracking.bookservice.dto;

import com.booktracking.bookservice.model.Book;
import jakarta.annotation.Nullable;

public record BookIdDto(
        @Nullable
        String id,
        String isbn
) {
    public static BookIdDto convert(Book book) {
        return new BookIdDto(book.getId(), book.getIsbn());
    }
}

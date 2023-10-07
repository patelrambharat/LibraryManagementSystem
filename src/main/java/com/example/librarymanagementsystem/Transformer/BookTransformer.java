package com.example.librarymanagementsystem.Transformer;

import com.example.librarymanagementsystem.DTO.responseDTO.BookResponse;
import com.example.librarymanagementsystem.model.Book;

public class BookTransformer {
    public  static BookResponse BookToBookResponse(Book book){
        return BookResponse.builder()
                .authorName(book.getAuthor().getName())
                .cost(book.getCost())
                .genre(book.getGenre())
                .noOfPages(book.getNoOfPages())
                .title(book.getTitle())
                .build();
    }
}

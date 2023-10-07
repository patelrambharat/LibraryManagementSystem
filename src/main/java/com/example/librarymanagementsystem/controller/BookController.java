package com.example.librarymanagementsystem.controller;

import com.example.librarymanagementsystem.DTO.responseDTO.BookResponseDTO;
import com.example.librarymanagementsystem.Enum.Genre;
import com.example.librarymanagementsystem.exception.AuthorNotFoundException;
import com.example.librarymanagementsystem.model.Book;
import com.example.librarymanagementsystem.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    BookService bookService;
    @PostMapping("/add")
    public String addBook(@RequestBody Book book){
        try {
            String response = bookService.addBook(book);
            return response;
        }
        catch (AuthorNotFoundException e){
            return e.getMessage();
        }
    }

    //delete a book
    //give me names of all the books of a particular genre
        //Using hibernate query language

    //give me names of all the books of a particular genre and cost greater than x rs
    @GetMapping("/get-by-genre-cost")
    public List<BookResponseDTO> getBooksByGenreAndCostGreaterThan(@RequestParam("genre") String genre, @RequestParam("cost") double cost){
       return bookService.getBooksByGenreAndCostGreaterThan(genre, cost);

    }

    @GetMapping("/get-by-genre-cost-hql")
    public List<BookResponseDTO> getBooksByGenreAndCostGreaterThanHQL(@RequestParam("genre") Genre genre, @RequestParam("cost") double cost){
        return bookService.getBooksByGenreAndCostGreaterThanHQL(genre, cost);

    }

    //give me all the books having number of pages between 'a' and 'b'

    //give me the name of all the authors who write the particular genre




}

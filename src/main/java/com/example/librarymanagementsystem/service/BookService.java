package com.example.librarymanagementsystem.service;

import com.example.librarymanagementsystem.exception.AuthorNotFoundException;
import com.example.librarymanagementsystem.model.Author;
import com.example.librarymanagementsystem.model.Book;
import com.example.librarymanagementsystem.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookService {
    @Autowired
    AuthorRepository authorRepository;
    public String addBook(Book book) {
                //check if author exists or not
            Optional<Author> authorOptional = authorRepository.findById(book.getAuthor().getId());
            if(authorOptional.isEmpty()){
                throw new AuthorNotFoundException("Invalid Author id !!1");
            }
            Author author = authorOptional.get();  //getting the author from author class
            book.setAuthor(author);        //two entity book and entity
            author.getBooks().add(book);   //add the book
            //now I have to save all

            authorRepository.save(author);  //save both author and book
            return "Book added Successfully";

    }
}

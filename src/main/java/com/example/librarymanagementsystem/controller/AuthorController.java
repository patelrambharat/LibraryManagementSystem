package com.example.librarymanagementsystem.controller;

import com.example.librarymanagementsystem.model.Author;
import com.example.librarymanagementsystem.service.Impl.AuthorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/author")
public class AuthorController {
    @Autowired
    AuthorServiceImpl authorServiceImpl;

    @PostMapping("/add")
    public ResponseEntity addAuthor(@RequestBody Author author){
        String response = authorServiceImpl.addAuthor(author);
        return new ResponseEntity(response, HttpStatus.CREATED);
    }

    //update the email id of an author --> observe lastActivity column

    //Give me names of all the books written by a particular author
    //Give me names of authors who have written 'x' number of books




}

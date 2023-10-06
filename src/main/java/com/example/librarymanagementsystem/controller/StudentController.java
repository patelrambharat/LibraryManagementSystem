package com.example.librarymanagementsystem.controller;

import com.example.librarymanagementsystem.DTO.requestDTO.StudentRequest;
import com.example.librarymanagementsystem.DTO.responseDTO.StudentRespose;
import com.example.librarymanagementsystem.service.StudentService;
import com.example.librarymanagementsystem.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    StudentService studentService;
    @PostMapping("/add")
    public ResponseEntity addStudent(@RequestBody StudentRequest studentRequest){
        StudentRespose response = studentService.addStudent(studentRequest);
        return new ResponseEntity(response, HttpStatus.CREATED);
    }
    @GetMapping("/get")
    public ResponseEntity getStudent(@RequestParam("id") int regNo){
       Student student =  studentService.getStudent(regNo);
       if(student != null){
           return new ResponseEntity(student, HttpStatus.FOUND);
       }
       return new ResponseEntity("Invalid id !" , HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/get-males")
    public List<String> getAllMales(){
        List<String> males = studentService.getAllMales();
        return males;
    }


}

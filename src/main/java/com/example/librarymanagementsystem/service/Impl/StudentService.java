package com.example.librarymanagementsystem.service.Impl;

import com.example.librarymanagementsystem.DTO.requestDTO.StudentRequest;
import com.example.librarymanagementsystem.DTO.responseDTO.LibraryCardReponse;
import com.example.librarymanagementsystem.DTO.responseDTO.StudentRespose;
import com.example.librarymanagementsystem.Enum.CardStatus;
import com.example.librarymanagementsystem.Enum.Gender;
import com.example.librarymanagementsystem.Transformer.LibraryCardTransformer;
import com.example.librarymanagementsystem.Transformer.StudentTransformer;
import com.example.librarymanagementsystem.model.LibraryCard;
import com.example.librarymanagementsystem.repository.StudentRepository;
import com.example.librarymanagementsystem.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;
    public StudentRespose addStudent(StudentRequest studentRequest) {

        Student student = StudentTransformer.StudentRequestToStudent(studentRequest);

        LibraryCard card = LibraryCardTransformer.preparedLibraryCard(student);
        card.setStudent(student);

        student.setLibraryCard(card);  //set the library card for student
        Student savedStudent  = studentRepository.save(student);  //it will save both student and library

//        saved model to response DTO
        return StudentTransformer.StudentToStudentResponse(savedStudent);

    }

    public Student getStudent(int regNo) {
        Optional<Student> studentOptional = studentRepository.findById(regNo);   //it my give you the res might not give the res
        if(studentOptional.isPresent()){
            return studentOptional.get();
        }
        return null;
    }

    List<String> names = new ArrayList<>();
    public List<String>getAllMales(){
        List<Student> students = studentRepository.findByGender(Gender.MALE);
        for(Student s : students){
            names.add(s.getName());
        }
        return names;
    }

    //this is the developer logic

    //delete a student --> regNo
    //update the age of student --> regNo , age
    //get all the student in the db  --> findAll()
    //list of all male student


}

package com.example.librarymanagementsystem.service;

import com.example.librarymanagementsystem.DTO.requestDTO.StudentRequest;
import com.example.librarymanagementsystem.DTO.responseDTO.LibraryCardReponse;
import com.example.librarymanagementsystem.DTO.responseDTO.StudentRespose;
import com.example.librarymanagementsystem.Enum.CardStatus;
import com.example.librarymanagementsystem.Enum.Gender;
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

        //convert DTO to model

//        Student student = new Student();
//        student.setName(studentRequest.getName());
//        student.setAge(studentRequest.getAge());
//        student.setGender(studentRequest.getGender());
//        student.setEmail(studentRequest.getEmail());
        //create object using builder

        Student student = StudentTransformer.StudentRequestToStudent(studentRequest);
        //give a library card
//        LibraryCard libraryCard = new LibraryCard();   //make a library card object and give the student
//        libraryCard.setCardNo(String.valueOf(UUID.randomUUID()));
//        libraryCard.setCardStatus(CardStatus.ACTIVE);
//        libraryCard.setStudent(student);   //set the student

        LibraryCard libraryCard = LibraryCard.builder()
                .cardNo(String.valueOf(UUID.randomUUID()))
                .cardStatus(CardStatus.ACTIVE)
                .student(student)
                .build();

        student.setLibraryCard(libraryCard);  //set the library card for student

       Student savedStudent  = studentRepository.save(student);  //it will save both student and library

//        saved model to response DTO
        StudentRespose studentRespose = new StudentRespose();
        studentRespose.setName(savedStudent.getName());
        studentRespose.setEmail(savedStudent.getEmail());
        studentRespose.setMessage("You have been registered");

//        LibraryCardReponse cardReponse = new LibraryCardReponse();
//        cardReponse.setCardNo(savedStudent.getLibraryCard().getCardNo());
//        cardReponse.setIssueDate(savedStudent.getLibraryCard().getIssueDate());
//        cardReponse.setCardStatus(savedStudent.getLibraryCard().getCardStatus());

        LibraryCardReponse cardReponse = LibraryCardReponse.builder()
                .cardNo(savedStudent.getLibraryCard().getCardNo())
                .cardStatus(savedStudent.getLibraryCard().getCardStatus())
                .issueDate(savedStudent.getLibraryCard().getIssueDate())
                .build();

        studentRespose.setLibraryCardReponse(cardReponse);
        return studentRespose;
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

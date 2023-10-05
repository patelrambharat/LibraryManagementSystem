package com.example.librarymanagementsystem.service;

import com.example.librarymanagementsystem.Enum.CardStatus;
import com.example.librarymanagementsystem.Enum.Gender;
import com.example.librarymanagementsystem.model.LibraryCard;
import com.example.librarymanagementsystem.repository.StudentRepository;
import com.example.librarymanagementsystem.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;
    public String addStudent(Student student) {

        LibraryCard libraryCard = new LibraryCard();   //make a library card object and give the student
        libraryCard.setCardNo(String.valueOf(UUID.randomUUID()));
        libraryCard.setCardStatus(CardStatus.ACTIVE);
        libraryCard.setStudent(student);   //set the student

        student.setLibraryCard(libraryCard);  //set the library card

       Student savedStudent  = studentRepository.save(student);  //it will save both student and library
       return "Student added successfully";
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


    //delete a student --> regNo
    //update the age of student --> regNo , age
    //get all the student in the db  --> findAll()
    //list of all male student


}

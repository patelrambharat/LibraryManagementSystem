package com.example.librarymanagementsystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentService {
    @Autowired StudentRepository studentRepository;
    public Student addStudent(Student student) {
       Student savedStudent  = studentRepository.save(student);
       return savedStudent;
    }

    public Student getStudent(int regNo) {
        Optional<Student> studentOptional = studentRepository.findById(regNo);   //it my give you the res might not give the res
        if(studentOptional.isPresent()){
            return studentOptional.get();
        }
        return null;
    }
    //delete a student --> regNo
    //update the age of student --> regNo , age
    //get all the student in the db
    //list of all male student

}

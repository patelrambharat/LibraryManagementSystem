package com.example.librarymanagementsystem.Transformer;

import com.example.librarymanagementsystem.DTO.requestDTO.StudentRequest;
import com.example.librarymanagementsystem.model.Student;

public class StudentTransformer {
    public static Student StudentRequestToStudent(StudentRequest studentRequest){
        return Student.builder()
                .name(studentRequest.getName())
                .age(studentRequest.getAge())
                .email(studentRequest.getEmail())
                .gender(studentRequest.getGender())
                .build();   //Student is the class name
    }
    public static  Student StudentResponse()
}

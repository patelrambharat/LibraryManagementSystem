package com.example.librarymanagementsystem.Transformer;

import com.example.librarymanagementsystem.DTO.requestDTO.StudentRequest;
import com.example.librarymanagementsystem.DTO.responseDTO.LibraryCardReponse;
import com.example.librarymanagementsystem.DTO.responseDTO.StudentRespose;
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
    public static StudentRespose StudentToStudentResponse(Student student){

        LibraryCardReponse cardReponse = LibraryCardReponse.builder()
                .cardNo(student.getLibraryCard().getCardNo())
                .cardStatus(student.getLibraryCard().getCardStatus())
                .issueDate(student.getLibraryCard().getIssueDate())
                .build();
        return StudentRespose.builder()
                .name(student.getName())
                .email(student.getEmail())
                .libraryCardReponse(cardReponse)
                .build();
    }


}

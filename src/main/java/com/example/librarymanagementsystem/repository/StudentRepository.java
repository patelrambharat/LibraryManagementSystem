package com.example.librarymanagementsystem.repository;

import com.example.librarymanagementsystem.Enum.Gender;
import com.example.librarymanagementsystem.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

//why interface -->
@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> {

    //define the function to find the male
    //implementation will take care by hibernate
    List<Student>findByGender(Gender gender);

    Student findByEmail(String email);

    Student findByGenderAndEmail(Gender gender, String email);  //sequence will matter

}

package com.example.librarymanagementsystem.repository;

import com.example.librarymanagementsystem.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//why interface -->
@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> {


}

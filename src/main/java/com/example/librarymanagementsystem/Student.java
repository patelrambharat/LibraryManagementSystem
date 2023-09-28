package com.example.librarymanagementsystem;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)  //set all the value as private
@NoArgsConstructor   //default constructor
@AllArgsConstructor   //const apart from no args
@Getter
@Setter     //they will create public method
@Entity   //to tell JPA that this is the model class
@Table(name = "student_info")
public class Student {
    @Id   //this attribute is my primary key
    int regNo;

    @Column(name = "student_name")   //updating anything in the middle will create a new column
    String name;
    int age;
    String email;
    @Enumerated(EnumType.STRING)  //it is show the value of enum in the form of string rather the int
    Gender gender;
}

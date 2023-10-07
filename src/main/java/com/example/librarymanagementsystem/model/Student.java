package com.example.librarymanagementsystem.model;

import com.example.librarymanagementsystem.Enum.Gender;
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
@Builder   //it is part of lambo
public class Student {
    @Id   //this attribute is my primary key
    //data type of GenerationType --> Enum
    @GeneratedValue(strategy =  GenerationType.IDENTITY)  //this will be automatic generate
    int regNo;

    @Column(name = "student_name")   //updating anything in the middle will create a new column
    String name;
    int age;
    @Column(unique = true , nullable = false)
    String email;

    @Enumerated(EnumType.STRING)  //it is show the value of enum in the form of string rather the int
    Gender gender;
    
    @OneToOne(mappedBy = "student", cascade =  CascadeType.ALL) //this is how create parent of the child
            //using cascade it will directly save when you will save as parent to child
    LibraryCard libraryCard;  //the value of library card you should write it
    

}

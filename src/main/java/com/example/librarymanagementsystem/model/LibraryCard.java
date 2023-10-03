package com.example.librarymanagementsystem.model;

import com.example.librarymanagementsystem.Enum.CardStatus;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;

import java.util.Date;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class LibraryCard {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)  //this will be automatic generate
    int id;

    String cardNo;   //we can generate unique card no using UUID  //we can make this one also primary
    @Enumerated(EnumType.STRING)
    CardStatus cardStatus;

    @CreationTimestamp
    Date issueDate;   //this will automatically generate by the system
    @OneToOne   //tells the relation between library card and student
    @JoinColumn  //it will create the foreing key of this column and by default it will be the primary key
    Student student;


}

package com.example.librarymanagementsystem.DTO.responseDTO;

import com.example.librarymanagementsystem.Enum.CardStatus;
import com.example.librarymanagementsystem.model.Student;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;


import java.util.Date;
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class LibraryCardReponse {

    String cardNo;   //we can generate unique card no using UUID  //we can make this one also primary

    CardStatus cardStatus;


    Date issueDate;   //this will automatically generate by the system


}

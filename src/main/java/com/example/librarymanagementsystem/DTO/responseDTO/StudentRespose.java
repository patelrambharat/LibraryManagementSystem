package com.example.librarymanagementsystem.DTO.responseDTO;

import com.example.librarymanagementsystem.model.LibraryCard;
import lombok.*;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class StudentRespose {

    String name;

    String email;



    LibraryCardReponse libraryCardReponse;
}

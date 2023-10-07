package com.example.librarymanagementsystem.Transformer;

import com.example.librarymanagementsystem.Enum.CardStatus;
import com.example.librarymanagementsystem.model.LibraryCard;
import com.example.librarymanagementsystem.model.Student;

import java.util.UUID;

public class LibraryCardTransformer {
    public static LibraryCard preparedLibraryCard(Student student){
        return LibraryCard.builder()
                .cardNo(String.valueOf(UUID.randomUUID()))
                .cardStatus(CardStatus.ACTIVE)
                .build();
    }
}

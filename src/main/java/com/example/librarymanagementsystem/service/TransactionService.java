package com.example.librarymanagementsystem.service;

import com.example.librarymanagementsystem.DTO.responseDTO.IssueBookResponse;
import com.example.librarymanagementsystem.Enum.TransactionStatus;
import com.example.librarymanagementsystem.exception.BookNotAvailable;
import com.example.librarymanagementsystem.exception.StudentNotFountException;
import com.example.librarymanagementsystem.model.Book;
import com.example.librarymanagementsystem.model.Student;
import com.example.librarymanagementsystem.model.Transaction;
import com.example.librarymanagementsystem.repository.BookRepository;
import com.example.librarymanagementsystem.repository.StudentRepository;
import com.example.librarymanagementsystem.repository.TransactionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class TransactionService {

    @Autowired
    StudentRepository studentRepository;
    @Autowired
    BookRepository bookRepository;

    @Autowired
    JavaMailSender javaMailSender;

    @Autowired
    TransactionRepo transactionRepo;
    public IssueBookResponse issueBook(int bookId, int studentId) {
        Optional<Student> studentOptional = studentRepository.findById(studentId);
        if(studentOptional.isEmpty()){
            throw new StudentNotFountException("Invalid student id !!1");
        }
        Optional<Book> optionalBook = bookRepository.findById(bookId);
        if(optionalBook.isEmpty()){
            throw new BookNotAvailable("Invalid book id !!!");
        }
        Book book = optionalBook.get();
        if(book.isIssued()){
            throw new BookNotAvailable("Book already issued");
        }

        //issued the book
        Student student = studentOptional.get();

        //create transaction
        Transaction transaction = Transaction.builder()
                .transactionNumber(String.valueOf(UUID.randomUUID()))
                .transactionStatus(TransactionStatus.SUCCESS)
                .book(book)
                .libraryCard(student.getLibraryCard())
                .build();

        Transaction savedTransaction = transactionRepo.save(transaction);
        //update book
        book.setIssued(true);
        book.getTransactions().add(savedTransaction);

        //card changes
        student.getLibraryCard().getTransactions().add(savedTransaction);

        Book savedBook = bookRepository.save(book);  //book and transaction
        Student saveStudent = studentRepository.save(student);  //student and transaction

        //  send an email
        String text = "Hi! " + student.getName() + " The below book has been issued to you\n" +
                book.getTitle() + " \nThis is the transaction number: "+savedTransaction.getTransactionNumber();

        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom("patelrambharat@gmail.com");
        simpleMailMessage.setTo(student.getEmail());
        simpleMailMessage.setSubject("Congrats!! Book Issued");
        simpleMailMessage.setText(text);

        javaMailSender.send(simpleMailMessage);
        //prepare response
        return IssueBookResponse.builder()
                .bookName(savedBook.getTitle())
                .transactionStatus(savedTransaction.getTransactionStatus())
                .transactionTime(savedTransaction.getTransactionTime())
                .transactionNumber(savedTransaction.getTransactionNumber())
                .studentName(saveStudent.getName())
                .libraryCardNumber(saveStudent.getLibraryCard().getCardNo())
                .authorName(savedBook.getAuthor().getName())
                .build();
    }

    //return book api code yourself
    //utility class the class where all the member is static is called utility class

}

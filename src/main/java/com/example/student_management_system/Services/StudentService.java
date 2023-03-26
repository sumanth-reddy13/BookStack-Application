package com.example.student_management_system.Services;

import com.example.student_management_system.Dto.StudentUpdateMobRequestDto;
import com.example.student_management_system.Enums.CardStatus;
import com.example.student_management_system.Models.Book;
import com.example.student_management_system.Models.Card;
import com.example.student_management_system.Models.Student;
import com.example.student_management_system.Repositories.BookRepository;
import com.example.student_management_system.Repositories.CardRepository;
import com.example.student_management_system.Repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;
    @Autowired
    BookRepository bookRepository;
    @Autowired
    CardRepository cardRepository;

    public String createStudent(Student student) {

        Card card = new Card();
        card.setCardStatus(CardStatus.ACTIVATED);
        card.setStudent(student);        // setting the foreign key in card Entity.

        student.setCard(card);

        studentRepository.save(student);
        return "student created successfully";
    }


    public String updateMobileNo(StudentUpdateMobRequestDto studentUpdateMobRequestDto) {

        Student student = studentRepository.findById(studentUpdateMobRequestDto.getId()).get();
        student.setMobile(studentUpdateMobRequestDto.getMobileNumber());

        studentRepository.save(student);
        return "Mobile Number updated successfully";

    }
    public String delete(int id) {

        studentRepository.deleteById(id);
        return "student deleted";
    }

    public Student findStudent(String email) {
        return studentRepository.findByEmail(email);
    }
    public String getBook(String bookName, int student_id) {
        Student student = studentRepository.findById(student_id).get();
        Card card = student.getCard();
        Book book = bookRepository.findByName(bookName);
        book.setCard(card);
        book.setIssued(true);

        card.setStudent(student);
        card.getBooksIssued().add(book);


        cardRepository.save(card);
        studentRepository.save(student);
        return "book issued";
    }
}

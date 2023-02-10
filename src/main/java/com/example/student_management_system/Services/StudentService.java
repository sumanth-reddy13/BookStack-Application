package com.example.student_management_system.Services;

import com.example.student_management_system.Enums.CardStatus;
import com.example.student_management_system.Models.Card;
import com.example.student_management_system.Models.Student;
import com.example.student_management_system.Repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    public String createStudent(Student student) {

        Card card = new Card();
        card.setCardStatus(CardStatus.ACTIVATED);
        card.setStudent(student);

        student.setCard(card);
        studentRepository.save(student);
        return "student created successfully";
    }

    public String delete(Student student) {

        studentRepository.delete(student);
//        studentRepository.deleteById(id);
        return "student deleted";
    }
}

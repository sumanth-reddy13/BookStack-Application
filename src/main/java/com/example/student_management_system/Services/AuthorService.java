package com.example.student_management_system.Services;

import com.example.student_management_system.Models.Author;
import com.example.student_management_system.Repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorService {

    @Autowired
    AuthorRepository authorRepository;
    public String addAuthor(Author author) {
        authorRepository.save(author);
        return "author added successfully";
    }
}

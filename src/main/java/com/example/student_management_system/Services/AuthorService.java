package com.example.student_management_system.Services;

import com.example.student_management_system.Dto.AuthorEntryDto;
import com.example.student_management_system.Dto.StudentUpdateMobRequestDto;
import com.example.student_management_system.Models.Author;
import com.example.student_management_system.Models.Student;
import com.example.student_management_system.Repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorService {

    @Autowired
    AuthorRepository authorRepository;
    public String createAuthor(AuthorEntryDto authorEntryDto) {

        // we took the object of type DTO but the repository layer
        // only interacts with entities. So we convert the DTO to an Author object before saving in the database.

        Author author = new Author();

        author.setName(authorEntryDto.getName());
        author.setAge(authorEntryDto.getAge());
        author.setCountry(authorEntryDto.getCountry());
        author.setRating(authorEntryDto.getRating());

        authorRepository.save(author);

        return "Author added successfully";
    }



}

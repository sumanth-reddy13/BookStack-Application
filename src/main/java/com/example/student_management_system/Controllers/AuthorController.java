package com.example.student_management_system.Controllers;

import com.example.student_management_system.Dto.AuthorEntryDto;
import com.example.student_management_system.Dto.StudentUpdateMobRequestDto;
import com.example.student_management_system.Models.Author;
import com.example.student_management_system.Services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("author")
public class AuthorController {

    @Autowired
    AuthorService authorService;

    @PostMapping("add")
    public String createAuthor(@RequestBody AuthorEntryDto authorEntryDto) {

        return authorService.createAuthor(authorEntryDto);
    }

}

package com.example.student_management_system.Controllers;

import com.example.student_management_system.Dto.AuthorEntryDto;
import com.example.student_management_system.ResponseDTO;
import com.example.student_management_system.Services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController       // RestController -> Controller + ResponseBody

@RequestMapping("author")         // maps the class to the URL.
public class AuthorController {

    @Autowired
    AuthorService authorService;

    @PostMapping("add")
    public String createAuthor(@RequestBody AuthorEntryDto authorEntryDto) {

        return authorService.createAuthor(authorEntryDto);
    }

    @GetMapping(value = "/sample", produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseDTO sample() {
        return new ResponseDTO("Hi there");
    }

}

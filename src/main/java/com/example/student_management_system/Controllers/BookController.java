package com.example.student_management_system.Controllers;

import com.example.student_management_system.Models.Book;
import com.example.student_management_system.Services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("book")
public class BookController {
    @Autowired
    BookService bookService;

    @PostMapping("add")
    public String addBook(@RequestBody Book book) {
        return bookService.addBook(book);


    }
}

package com.example.student_management_system.Services;

import com.example.student_management_system.Models.Author;
import com.example.student_management_system.Models.Book;
import com.example.student_management_system.Repositories.AuthorRepository;
import com.example.student_management_system.Repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    @Autowired
    AuthorRepository authorRepository;
    @Autowired
    BookRepository bookRepository;
    public String addBook(Book book) {

        int authorId = book.getAuthor().getId();
        Author author;
        try {
            author = authorRepository.findById(authorId).get();
        }
        catch(Exception e) {
            return "author not found";
        }

        author.getBooksWritten().add(book);

        book.setAuthor(author);

        authorRepository.save(author);
//        bookRepository.save(book);
//
        return "book added successfully";
    }
}

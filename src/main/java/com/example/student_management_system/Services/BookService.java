package com.example.student_management_system.Services;

import com.example.student_management_system.Dto.BookRequestDto;
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

    public String addBook(BookRequestDto bookReq) {

        Book book = new Book();
        book.setName(bookReq.getName());
        book.setPages(bookReq.getPages());
        book.setGenre(bookReq.getGenre());
        book.setIssued(book.isIssued());

        // As we have bidirectional mapping b/w Author & Book, we create an Author class and save it to the repository.
        // The book Entity will be directly updated with Author Entity as both have bidirectional mapping.

        Author author = authorRepository.findById(bookReq.getAuthorId()).get();

        book.setAuthor(author);

        author.getBooksWritten().add(book);   // adding book to the ListOfBooks.

        authorRepository.save(author);

        return "book added successfully";
    }
}

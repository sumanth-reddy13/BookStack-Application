package com.example.student_management_system.Services;

import com.example.student_management_system.Dto.IssueBookRequestDto;
import com.example.student_management_system.Enums.TransactionStatus;
import com.example.student_management_system.Models.Book;
import com.example.student_management_system.Models.Card;
import com.example.student_management_system.Models.Transaction;
import com.example.student_management_system.Repositories.BookRepository;
import com.example.student_management_system.Repositories.CardRepository;
import com.example.student_management_system.Repositories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {

    @Autowired
    TransactionRepository transactionRepository;

    @Autowired
    BookRepository bookRepository;

    @Autowired
    CardRepository cardRepository;

    public String issueBook(IssueBookRequestDto issueBookReq) {

        int bookId = issueBookReq.getBookId();
        Book book = bookRepository.findById(bookId).get();

        int cardId = issueBookReq.getCardId();
        Card card = cardRepository.findById(cardId).get();

        Transaction transaction = new Transaction();

        transaction.setTransactionStatus(TransactionStatus.SUCCESS);
        transaction.setFine(0);
        transaction.setIssuedOperation(true);


        card.getTransactionsList().add(transaction);
        card.getBooksIssued().add(book);


        book.getTransactionsList().add(transaction);
        book.setCard(card);
        book.setIssued(true);

        transaction.setBook(book);
        transaction.setCard(card);

        cardRepository.save(card);
        return "book issued";
    }
}

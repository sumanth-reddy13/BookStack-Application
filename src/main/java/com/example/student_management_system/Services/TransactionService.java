package com.example.student_management_system.Services;

import com.example.student_management_system.Dto.IssueBookRequestDto;
import com.example.student_management_system.Enums.CardStatus;
import com.example.student_management_system.Enums.TransactionStatus;
import com.example.student_management_system.Models.Book;
import com.example.student_management_system.Models.Card;
import com.example.student_management_system.Models.Transaction;
import com.example.student_management_system.Repositories.BookRepository;
import com.example.student_management_system.Repositories.CardRepository;
import com.example.student_management_system.Repositories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.ZoneId;

import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;

@Service
public class TransactionService {

    @Autowired
    TransactionRepository transactionRepository;

    @Autowired
    BookRepository bookRepository;

    @Autowired
    CardRepository cardRepository;

    public String issueBook(IssueBookRequestDto issueBookReq) throws Exception {

        int bookId = issueBookReq.getBookId();
        int cardId = issueBookReq.getCardId();

        // why we need book and card object is, before saving transaction we have to set all its attributes.

        Book book = bookRepository.findById(bookId).get();
        Card card = cardRepository.findById(cardId).get();


        Transaction transaction = new Transaction();

        // setting transaction attributes.

        transaction.setTransactionStatus(TransactionStatus.PENDING);
        transaction.setFine(0);
        transaction.setIssuedOperation(false);
        transaction.setBook(book);
        transaction.setCard(card);

        if (book == null || book.isIssued() == true) {
            transaction.setTransactionStatus(TransactionStatus.FAILED);
            transactionRepository.save(transaction);
            throw new Exception("book already issued");
        }

        if (card == null || card.getCardStatus() != CardStatus.ACTIVATED) {
            transaction.setTransactionStatus(TransactionStatus.FAILED);
            transactionRepository.save(transaction);
            throw new Exception("card is not valid");
        }


        transaction.setTransactionStatus(TransactionStatus.SUCCESS);
        transaction.setIssuedOperation(true);
        card.getTransactionsList().add(transaction);   // adding transaction to card Entity
        card.getBooksIssued().add(book);               // adding the issued book to list of Books issued to the card


        book.getTransactionsList().add(transaction);     // transaction added to book entity
        book.setCard(card);
        book.setIssued(true);


        cardRepository.save(card);
        return "book issued";
    }

    public String getTransactions(int cardId, int bookId) {
        List<Transaction> transactionList = transactionRepository.getTransactionListForBookAndCard(cardId, bookId);
        String s = transactionList.get(0).getTransactionId();
        return s;
    }

    public String returnBook(int cardId, int bookId) throws Exception {
        Card card = cardRepository.findById(cardId).get();
        Book book = bookRepository.findById(bookId).get();

        Transaction lastTransaction = transactionRepository.getTransactionForBookAndCard(cardId, bookId);

        if (lastTransaction == null) {
            return "book is already returned";
        }
//        Transaction lastTransaction = transactionsListOfBookAndCard.get(transactionsListOfBookAndCard.size() - 1);
        if (!book.isIssued()) {
            return "book is not issued";
        }

        Transaction returnTransaction = new Transaction();
        returnTransaction.setTransactionStatus(TransactionStatus.PENDING);
        returnTransaction.setIssuedOperation(false);

        LocalDate returnDate = LocalDate.now();
        LocalDate lastReturnDateOfTheBookWithoutFine = lastTransaction.getTransactionDate().plusDays(15);

        int days = 0;
        if (returnDate.equals(lastReturnDateOfTheBookWithoutFine) || returnDate.isBefore(lastReturnDateOfTheBookWithoutFine)) {
            returnTransaction.setFine(0);
        } else {
            if (returnDate.getYear() == lastReturnDateOfTheBookWithoutFine.getYear()) {
                days = returnDate.getDayOfYear() - lastReturnDateOfTheBookWithoutFine.getDayOfYear();
            }
            else {
                days = (366 - returnDate.getDayOfYear()) + lastReturnDateOfTheBookWithoutFine.getDayOfYear();
                if (returnDate.isLeapYear()) {
                    days++;
                }
            }
        }
        int finePerDay = 10;
        returnTransaction.setFine(days * finePerDay);
        returnTransaction.setTransactionStatus(TransactionStatus.SUCCESS);
        returnTransaction.setBook(book);
        returnTransaction.setCard(card);

        returnTransaction = transactionRepository.save(returnTransaction);

        book.setCard(null);
        book.setIssued(false);
        book.getTransactionsList().add(returnTransaction);

        List<Book> list = card.getBooksIssued();
        list.remove(book);
        card.setBooksIssued(list);
        card.getTransactionsList().add(returnTransaction);

        cardRepository.save(card);

        return "return successful";
    }
}


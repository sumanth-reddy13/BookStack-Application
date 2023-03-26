package com.example.student_management_system.Repositories;

import com.example.student_management_system.Models.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Integer> {

    @Query(value = "select * from transactions where card_id=:cardId and book_id=:bookId and is_issued_operation=true " +
            "order by id DESC LIMIT 1", nativeQuery = true)
    Transaction getTransactionForBookAndCard(int cardId, int bookId);

    @Query(value = "select * from transactions where card_id=:cardId and book_id=:bookId order by id ASC", nativeQuery = true)
    List<Transaction> getTransactionListForBookAndCard(int cardId, int bookId);

}

package com.example.student_management_system.Controllers;

import com.example.student_management_system.Dto.IssueBookRequestDto;
import com.example.student_management_system.Services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transaction")
public class TransactionController {

    @Autowired
    TransactionService transactionService;

    @PutMapping("/issueBook")
    public String issueBook(@RequestBody IssueBookRequestDto issueBookReq) {
        try {
            return transactionService.issueBook(issueBookReq);
        }catch(Exception e) {
            return e.getMessage();
        }
    }

    @GetMapping("/getTransaction")
    public String getTransaction(@RequestParam("cardId") int cardId,@RequestParam("bookId") int bookId) {

        return transactionService.getTransactions(cardId, bookId);
    }

    @PutMapping("/returnBook")
    public String returnBook(@RequestParam("cardId") int cardId, @RequestParam("bookId") int bookId) {
        try {
            return transactionService.returnBook(cardId, bookId);
        }
        catch(Exception e) {
            return e.getMessage();
        }
    }
}


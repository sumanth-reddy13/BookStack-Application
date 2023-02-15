package com.example.student_management_system.Controllers;

import com.example.student_management_system.Dto.IssueBookRequestDto;
import com.example.student_management_system.Services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transaction")
public class TransactionController {

    @Autowired
    TransactionService transactionService;

    @PutMapping("/issueBook")
    public String issueBook(@RequestBody IssueBookRequestDto issueBookReq) {
        return transactionService.issueBook(issueBookReq);
    }
}


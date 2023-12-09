package com.example.Library.Management.System.Controller;

import com.example.Library.Management.System.Entities.Book;
import com.example.Library.Management.System.Repository.TransactionRepository;
import com.example.Library.Management.System.Service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransactionController {

    @Autowired
    private TransactionService transactionService;


    @PostMapping("/issue_book")
    public String issueBook(@RequestBody Book Book){

        try{
            return transactionService.issueBook(Book);
        }catch (Exception e){
            return e.getMessage();
        }

    }
}

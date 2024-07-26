package com.phenol.transactionEndpoints;

import com.phenol.TransactionService.TransactionServices;
import com.phenol.transactionDomain.TransactionEntity.Transactions;
import com.phenol.transactionDomain.Type;
import com.phenol.transactionDomain.com.phenol.transactionDomain.TransactionDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tran")
public class TransactionController {

    @Autowired
    private TransactionServices transactionServices;

    @GetMapping("/test")
    public String test() {
        return "Hello Transaction!";
    }

    @GetMapping("/get")
    public List<Transactions> getAllTransactions() {
        return transactionServices.getAllTransaction();
    }

    @PostMapping("/post")
    public Transactions postTransaction(@RequestBody Transactions transactions) {
        return transactionServices.createTransaction(transactions);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteTransaction(@RequestBody Transactions transactions) {
        transactionServices.deleteTransaction(transactions);
        return ResponseEntity.ok().build();
    }

    // BORROW

    @GetMapping("/getBorrow")
    public List<TransactionDTO> getBorrowTransactions() {
        return transactionServices.getAllBorrowTransaction(Type.BORROW);
    }

    // RETURN

    @GetMapping("/getReturn")
    public List<TransactionDTO> getReturnTransactions() {
        return transactionServices.getAllReturnTransaction(Type.RETURN);
    }
}

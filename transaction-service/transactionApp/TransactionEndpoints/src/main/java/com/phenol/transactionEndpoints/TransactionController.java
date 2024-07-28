package com.phenol.transactionEndpoints;

import com.phenol.TransactionService.TransactionServices;
import com.phenol.TransactionService.kafkaService.KafkaTransactionProducer;
import com.phenol.transactionDomain.TransactionEntity.Transactions;
import com.phenol.transactionDomain.Type;
import com.phenol.transactionDomain.com.phenol.transactionDomain.TransactionDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/tran")
public class TransactionController {

    @Autowired
    private KafkaTransactionProducer kafkaTransactionProducer;

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
        Transactions transaction = transactionServices.createTransaction(transactions);
        kafkaTransactionProducer.sendMessage("Created transactions with Id: " + transaction.getId());
        return transaction;
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteTransaction(@RequestBody Transactions transactions) {
        transactionServices.deleteTransaction(transactions);
        kafkaTransactionProducer.sendMessage("Deleted transaction with Id: " + transactions.getId());
        return ResponseEntity.ok().build();
    }

    @PostMapping("/createTran/{userId}/{bookId}/{type}")
    public ResponseEntity<?> createTran(@PathVariable Long userId, @PathVariable Long bookId, @PathVariable Type type) {
        TransactionDTO tran = transactionServices.createTran(userId, bookId, type);
        kafkaTransactionProducer.sendMessage("Created transaction with Id: " + tran.getId() + " and books with" + tran.getBookId());
        return ResponseEntity.ok().body(tran);
    }

    @PostMapping("/setTran/{tranId}/{returnDate}")
    public ResponseEntity<?> setTran(@PathVariable Long tranId, @PathVariable LocalDate returnDate) {
        System.out.println(tranId);
        System.out.println(returnDate);
        kafkaTransactionProducer.sendMessage("created transaction with Id: " + tranId + " with returnDate: " + returnDate);
        return ResponseEntity.ok().build();
    }
    // BORROW

    @GetMapping("/getBorrow")
    public List<TransactionDTO> getBorrowTransactions() {
        kafkaTransactionProducer.sendMessage("Getting all the borrow transactions");
        return transactionServices.getAllBorrowTransaction(Type.BORROW);
    }


    // RETURN

    @GetMapping("/getReturn")
    public List<TransactionDTO> getReturnTransactions() {
        kafkaTransactionProducer.sendMessage("Retrieved all the return transactions");
        return transactionServices.getAllReturnTransaction(Type.RETURN);
    }
}

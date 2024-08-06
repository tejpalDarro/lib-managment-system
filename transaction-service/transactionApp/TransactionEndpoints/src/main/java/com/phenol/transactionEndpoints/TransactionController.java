package com.phenol.transactionEndpoints;

import com.phenol.TransactionService.TransactionServices;
import com.phenol.TransactionService.kafkaService.KafkaTransactionProducer;
import com.phenol.transactionDomain.TransactionEntity.Transactions;
import com.phenol.transactionDomain.Type;
import com.phenol.transactionDomain.com.phenol.transactionDomain.TransactionDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/tran")
public class TransactionController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private KafkaTransactionProducer kafkaTransactionProducer;

    @Autowired
    private TransactionServices transactionServices;

    @GetMapping("/test")
    public String test() {
        kafkaTransactionProducer.sendMessageToNotification("test message");
        return "Hello Transaction!";
    }

    @GetMapping("/get")
    public List<Transactions> getAllTransactions() {
        return transactionServices.getAllTransaction();
    }

    @PostMapping("/post")
    public TransactionDTO postTransaction(@RequestBody Transactions transactions) {
        TransactionDTO transaction = transactionServices.createTransaction(transactions);
        kafkaTransactionProducer.sendMessage("Created transactions with Id: " + transaction.getId());
        return transaction;
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteTransaction(@PathVariable Long id) {
        transactionServices.deleteTransaction(id);
        kafkaTransactionProducer.sendMessage("Deleted transaction with Id: " + id);
        return ResponseEntity.ok().build();
    }

    // creating a transaction
    @PostMapping("/createTran/{userId}/{bookId}/{type}")
    public ResponseEntity<?> createTran(@PathVariable Long userId, @PathVariable Long bookId, @PathVariable Type type) {
        String url = "http://notification/notif/create/" + userId + "/" + bookId + "/" + type;
        TransactionDTO tran = transactionServices.createTran(userId, bookId, type);
        kafkaTransactionProducer.sendMessageToNotification("Created transaction with Id: " + tran.getId() + " and books with" + tran.getBookId());
        return ResponseEntity.ok().body(tran);
    }

    // Return a book
    @PostMapping("/setTran/{tranId}/{returnDate}")
    public ResponseEntity<?> setTran(@PathVariable Long tranId, @PathVariable LocalDate returnDate) {
        String url = "http://notification/notif/create/" + userId + "/" + bookId + "/" + type;
        System.out.println(tranId);
        System.out.println(returnDate);
        kafkaTransactionProducer.sendMessageToNotification("created transaction with Id: " + tranId + " with returnDate: " + returnDate);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/restTest")
    public void getRestCall() {
        String url = "http://notification/notif/test";
        String s = String.valueOf(restTemplate.getForEntity(url, String.class));
        System.out.println("ok! rest template" + s);
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

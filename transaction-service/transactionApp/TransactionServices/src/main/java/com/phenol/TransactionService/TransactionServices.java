package com.phenol.TransactionService;

import com.phenol.transactionDomain.TransactionEntity.Transactions;
import com.phenol.transactionDomain.Type;
import com.phenol.transactionDomain.com.phenol.transactionDomain.TransactionDTO;

import java.util.List;

public interface TransactionServices {
    public List<Transactions> getAllTransaction();

    Transactions createTransaction(Transactions transactions);

    void deleteTransaction(Transactions transactions);

    List<TransactionDTO> getAllBorrowTransaction(Type transactionType);

    List<TransactionDTO> getAllReturnTransaction(Type type);


    TransactionDTO createTran(Long userId, Long bookId, Type type);
}

package com.phenol.TransactionService;

import com.phenol.transactionDomain.TransactionEntity.Transactions;
import com.phenol.transactionDomain.Type;
import com.phenol.transactionDomain.com.phenol.transactionDomain.TransactionDTO;

import java.util.List;

public interface TransactionServices {
    public List<Transactions> getAllTransaction();

    TransactionDTO createTransaction(Transactions transactions);

    void deleteTransaction(Long id);

    List<TransactionDTO> getAllBorrowTransaction(Type transactionType);

    List<TransactionDTO> getAllReturnTransaction(Type type);


    TransactionDTO createTran(Long userId, Long bookId, Type type);
}

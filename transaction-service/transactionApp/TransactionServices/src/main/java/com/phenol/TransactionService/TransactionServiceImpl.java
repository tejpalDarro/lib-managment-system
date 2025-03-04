package com.phenol.TransactionService;

import com.phenol.TransactionService.mapper.TransactionMapper;
import com.phenol.transactionDomain.TransactionEntity.Transactions;
import com.phenol.transactionDomain.Type;
import com.phenol.transactionDomain.com.phenol.transactionDomain.TransactionDTO;
import com.phenol.transactionRepository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionServices{

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private TransactionMapper transactionMapper;

    @Override
    public List<Transactions> getAllTransaction() {
        return transactionRepository.findAll();
    }

    @Override
    public Transactions createTransaction(Transactions transactions) {
        return transactionRepository.save(transactions);
    }

    @Override
    public void deleteTransaction(Transactions transactions) {
        transactionRepository.delete(transactions);
    }

    @Override
    public List<TransactionDTO> getAllBorrowTransaction(Type transactionType) {
        List<Transactions> byTransactionType = transactionRepository.findByTransactionType(transactionType);
        return  transactionMapper.getDTOList(byTransactionType);
    }

    @Override
    public List<TransactionDTO> getAllReturnTransaction(Type type) {
        List<Transactions> byTransactionType = transactionRepository.findByTransactionType(type);
        return  transactionMapper.getDTOList(byTransactionType);
    }

    @Override
    public TransactionDTO createTran(Long userId, Long bookId, Type type) {
        Transactions tran = new Transactions();
        tran.setBookId(bookId);
        tran.setUserId(userId);
        tran.setDueDate(LocalDate.now().plusWeeks(1));
        tran.setTransactionDate(LocalDate.now());
        tran.setReturnDate(null);
        tran.setTransactionType(type);
        Transactions save = transactionRepository.save(tran);
        return transactionMapper.getDTO(save);
    }
}

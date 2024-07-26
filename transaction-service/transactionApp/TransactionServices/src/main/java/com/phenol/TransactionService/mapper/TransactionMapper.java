package com.phenol.TransactionService.mapper;

import com.phenol.transactionDomain.TransactionEntity.Transactions;
import com.phenol.transactionDomain.com.phenol.transactionDomain.TransactionDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionMapper {

    public TransactionDTO getDTO(Transactions transactions) {
        TransactionDTO dto = new TransactionDTO();
        dto.setId(transactions.getId());
        dto.setBookId(transactions.getBookId());
        dto.setTransactionDate(transactions.getTransactionDate());
        dto.setTransactionType(transactions.getTransactionType());
        dto.setUserId(transactions.getUserId());
        dto.setDueDate(transactions.getDueDate());
        dto.setReturnDate(transactions.getReturnDate());
        return dto;
    }

    public List<TransactionDTO> getDTOList(List<Transactions> transactions) {
        return transactions.stream()
                .map(TransactionMapper::dto)
                .toList();
    }

    public static TransactionDTO dto(Transactions transactions) {
        TransactionDTO dto = new TransactionDTO();
        dto.setId(transactions.getId());
        dto.setBookId(transactions.getBookId());
        dto.setTransactionDate(transactions.getTransactionDate());
        dto.setTransactionType(transactions.getTransactionType());
        dto.setUserId(transactions.getUserId());
        dto.setDueDate(transactions.getDueDate());
        dto.setReturnDate(transactions.getReturnDate());
        return dto;
    }
}

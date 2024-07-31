package com.phenol.notification;

import com.phenol.transactionDomain.TransactionEntity.Transactions;

public interface NotificationService {

    public void created(Transactions t);
}

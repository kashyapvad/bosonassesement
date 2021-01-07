package com.boson.assessment.types;

import com.boson.assessment.transactions.Transaction;

public interface Type {
    void processTransaction(Transaction transaction);
}

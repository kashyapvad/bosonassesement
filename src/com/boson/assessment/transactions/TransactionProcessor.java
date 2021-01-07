package com.boson.assessment.transactions;

import com.boson.assessment.types.Type;
import com.boson.assessment.types.TypeManager;

public class TransactionProcessor {

    public static void transactionProcessing() {
        Transaction transaction = TransactionManager.getInstance().getTransaction();
        while (transaction != null) {
            for (Type type : TypeManager.getInstance().getTypeList()) {
                type.processTransaction(transaction);
            }
            transaction = TransactionManager.getInstance().getTransaction();
        }
    }
}



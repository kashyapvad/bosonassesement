package com.boson.assessment;

import com.boson.assessment.transactions.TransactionManager;
import com.boson.assessment.users.UserManager;

public class Main {

    public static void main(String[] args) {
        TransactionManager.getInstance().processTransactions();
        UserManager.getInstance().printReport();
    }
}

package com.boson.assessment;

import com.boson.assessment.exceptions.BadParameterException;
import com.boson.assessment.exceptions.NullParameterException;
import com.boson.assessment.transactions.TransactionManager;
import com.boson.assessment.users.UserManager;

public class Main {

    public static void main(String[] args) throws NullParameterException, BadParameterException {
        TransactionManager.getInstance().processTransactions();
        UserManager.getInstance().printReport();
    }
}

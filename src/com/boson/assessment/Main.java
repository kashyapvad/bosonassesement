package com.boson.assessment;

import com.boson.assessment.exceptions.BadParameterException;
import com.boson.assessment.exceptions.NullParameterException;
import com.boson.assessment.transactions.TransactionManager;
import com.boson.assessment.users.UserManager;

public class Main {

    public static void main(String[] args) throws NullParameterException, BadParameterException {
/*        System.out.println("Customer's state before orders are processed");
        UserManager.getInstance().printReport();
        System.out.println("==================================================");
        System.out.println("Orders to be processed");
        TransactionManager.getInstance().printOrders();
        System.out.println("==================================================");
        System.out.println("Processing orders");
        TransactionManager.getInstance().processTransactions();
        System.out.println("==================================================");
        System.out.println("Processing done");
        System.out.println("==================================================");
        System.out.println("Shipping slips generated ");
        ShipmentManager.getInstance().printReport();
        System.out.println("Customer's state after orders are processed");
        UserManager.getInstance().printReport();
        System.out.println("==================================================");*/
        TransactionManager.getInstance().processTransactions();
        UserManager.getInstance().printReport();
    }
}

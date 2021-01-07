package com.boson.assessment.transactions;

import com.boson.assessment.XML.XMLloaderTransactions;
import com.boson.assessment.exceptions.BadParameterException;
import com.boson.assessment.exceptions.NullParameterException;

import java.util.List;

public class TransactionManager {
    private List<Transaction> transactionList;
    private static TransactionManager ourInstance;

    static {
        try {
            ourInstance = new TransactionManager();
        } catch (NullParameterException e) {
            e.printStackTrace();
        } catch (BadParameterException e) {
            e.printStackTrace();
        }
    }

    public static final String FILENAME = "../bosonassessment/data/transactions.xml";

    public static TransactionManager getInstance() {
        return ourInstance;
    }

    private TransactionManager() throws NullParameterException, BadParameterException {
        XMLloaderTransactions loader = new XMLloaderTransactions();
        transactionList = loader.getTransactionDataFromXML(FILENAME);
    }

    public void processTransactions() {
        TransactionProcessor.transactionProcessing();
    }

    public List<Transaction> transactions(){
        return transactionList;
    }

    public Transaction getTransaction() {
        if (transactionList.size() >= 1) {
            Transaction transaction = transactionList.get(0);
            transactionList.remove(transaction);
            return transaction;
        } else return null;
    }
}

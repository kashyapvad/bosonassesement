package com.boson.assessment.transactions;


import com.boson.assessment.Constants;
import com.boson.assessment.exceptions.BadParameterException;
import com.boson.assessment.exceptions.NullParameterException;
import com.boson.assessment.items.ItemCatalog;

public class TransactionFactory {

    public static Transaction transactionBuilder(Integer id,
                                                 String makerId,
                                                 String typeString,
                                                 String amountString,
                                                 String itemId,
                                                 String priceString) {
        return createTransaction(id, makerId, typeString, amountString, itemId, priceString);
    }


    private static Transaction createTransaction(Integer id,
                                                 String makerId,
                                                 String typeString,
                                                 String amountString,
                                                 String itemId,
                                                 String priceString) {
        Transaction transaction = null;
        try {
            if (Constants.isFinancial(typeString)) {
                Constants.FINANCIAL_KIND type = Constants.FINANCIAL_KIND.valueOf(typeString);
                Float amount = Float.parseFloat(amountString);
                transaction = new FinancialTransactionImpl(id, amount, makerId, type);
            } else if (Constants.isTrade(typeString)) {
                Constants.TRADE_KIND type = Constants.TRADE_KIND.valueOf(typeString);
                if (!ItemCatalog.getInstance().getIdSet().contains(itemId)) {
                    Float price = Float.parseFloat(priceString);
                    ItemCatalog.getInstance().addItem(itemId, price, makerId);
                }
                transaction = new TradeTransactionImpl(id, makerId, type, itemId);
            }
        } catch (IllegalArgumentException | NullParameterException | BadParameterException e) {
            System.out.println(typeString + " is not a valid type of transaction");
        }
        return transaction;
    }
}

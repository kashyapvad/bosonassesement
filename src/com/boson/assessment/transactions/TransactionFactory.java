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
                                                 String priceString) throws NullParameterException, BadParameterException {
        Transaction transaction = null;
        try {
            if (Constants.isFinancial(typeString)) {
                Constants.FINANCIAL_TYPE type = Constants.FINANCIAL_TYPE.valueOf(typeString);
                Float amount = Float.parseFloat(amountString);
                transaction = new FinancialTransactionImpl(id, amount, makerId, type);
            } else if(Constants.isTrade(typeString)) {
                Constants.TRADE_TYPE type = Constants.TRADE_TYPE.valueOf(typeString);
                if(!ItemCatalog.getInstance().getIdSet().contains(itemId)){
                    Float price = Float.parseFloat(priceString);
                    ItemCatalog.getInstance().addItem(itemId, price, makerId);
                }
                transaction = new TradeTransactionImpl(id, makerId, type, itemId);
            }
        } catch (IllegalArgumentException e) {
            System.out.println(typeString + " is not a valid type of transaction");
        }
        return transaction;
    }
}

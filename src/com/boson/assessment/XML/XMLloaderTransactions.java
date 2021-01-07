package com.boson.assessment.XML;


import com.boson.assessment.Constants;
import com.boson.assessment.exceptions.BadParameterException;
import com.boson.assessment.exceptions.NullParameterException;
import com.boson.assessment.items.ItemCatalog;
import com.boson.assessment.transactions.Transaction;
import com.boson.assessment.transactions.TransactionFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class XMLloaderTransactions {


    public List<Transaction> getTransactionDataFromXML(String filename) throws NullParameterException, BadParameterException {
        List<Transaction> data = new ArrayList<>();
        File xmlFile = new File(filename);
        Document doc = null;
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            doc = builder.parse(xmlFile);
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
        NodeList transactionList = doc.getElementsByTagName("Transaction");
        for (int i = 0; i < transactionList.getLength(); i++) {
            if (transactionList.item(i).getNodeType() == Node.TEXT_NODE) {
                continue;
            }

            String entryName = transactionList.item(i).getNodeName();

            if (!entryName.equals("Transaction")) {
                System.err.println("Unexpected node found: " + entryName);
                return null;
            }
            Element transactionElement = (Element) transactionList.item(i);
            String idContent = transactionElement.getElementsByTagName("Id").item(0).getTextContent();
            String userId = transactionElement.getElementsByTagName("MakerId").item(0).getTextContent();
            String typeContent = transactionElement.getElementsByTagName("Type").item(0).getTextContent();
            String amountContent = new String();
            String itemIdContent = new String();
            String priceContent = new String();

            if (Constants.isFinancial(typeContent)) {
                amountContent = transactionElement.getElementsByTagName("Amount").item(0).getTextContent();
            }
            Integer id = Integer.parseInt(idContent);

            if (Constants.isTrade(typeContent)) {
                NodeList itemList = transactionElement.getElementsByTagName("Item");
                for (int k = 0; k < itemList.getLength(); k++) {
                    if (itemList.item(k).getNodeType() == Node.TEXT_NODE) {
                        continue;
                    }

                    entryName = itemList.item(k).getNodeName();
                    if (!entryName.equals("Item")) {
                        System.err.println("Unexpected node found: " + entryName);
                        return null;
                    }

                    Element itemElement = (Element) itemList.item(k);
                    itemIdContent = itemElement.getElementsByTagName("ItemId").item(0).getTextContent();
                    if (!ItemCatalog.getInstance().getIdSet().contains(itemIdContent)){
                        priceContent = itemElement.getElementsByTagName("Price").item(0).getTextContent();
                    }
                }
            }
            data.add(TransactionFactory.transactionBuilder(id, userId, typeContent, amountContent, itemIdContent, priceContent));
        }
        return data;
    }
}



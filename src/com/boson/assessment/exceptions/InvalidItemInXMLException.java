package com.boson.assessment.exceptions;


public class InvalidItemInXMLException extends Exception {

    public InvalidItemInXMLException() {
    }

    public void invalidItemInXML(String message) {
        System.out.println(message);
    }
}

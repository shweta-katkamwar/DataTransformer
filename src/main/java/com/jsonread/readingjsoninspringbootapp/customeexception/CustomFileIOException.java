package com.jsonread.readingjsoninspringbootapp.customeexception;

public class CustomFileIOException extends Exception{

    public CustomFileIOException(String errorMessage) {
        super(errorMessage);
    }
}

package com.jsonread.readingjsoninspringbootapp.customeexception;

public class EmployeeNotFound extends Exception{
    public EmployeeNotFound(String errorMessage) {
        super(errorMessage);
    }
}

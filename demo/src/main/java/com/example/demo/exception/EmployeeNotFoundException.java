package com.example.demo.exception;

public class EmployeeNotFoundException extends Exception{
    public EmployeeNotFoundException (){
        super("Employee not found");
    }

    public EmployeeNotFoundException (String message){
        super(message);
    }
}

package com.jsonread.readingjsoninspringbootapp.controller;

import com.jsonread.readingjsoninspringbootapp.customeexception.CustomFileIOException;
import com.jsonread.readingjsoninspringbootapp.customeexception.EmployeeNotFound;
import com.jsonread.readingjsoninspringbootapp.modal.Employee;
import com.jsonread.readingjsoninspringbootapp.response.Response;
import com.jsonread.readingjsoninspringbootapp.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/employee")
    public ResponseEntity<Object> getAllEmployees() {
        List<Employee> allEmployee = null;
        try {
            allEmployee = employeeService.getAllEmployee();
        } catch (IOException ex) {
            Response response = new Response<>(ex.getMessage(),"file not found");
            return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(response);
            //throw new RuntimeException(e);
        }
        return ResponseEntity.status(HttpStatus.OK).body(allEmployee);
    }

    @GetMapping("/employee/{city}")
    public ResponseEntity<Object> getAllEmployeeOfPerticularCity(@PathVariable String city) {
        List<Employee> allEmployeeOfPerticularCity = employeeService.getAllEmployeeOfPerticularCity(city);
        if(ObjectUtils.isEmpty(allEmployeeOfPerticularCity)) {
            Response<String> response = new Response<>("No employees found in the specified city");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
        return ResponseEntity.status(HttpStatus.OK).body(allEmployeeOfPerticularCity);
    }
}

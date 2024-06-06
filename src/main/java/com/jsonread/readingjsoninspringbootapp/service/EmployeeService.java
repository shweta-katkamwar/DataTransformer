package com.jsonread.readingjsoninspringbootapp.service;

import com.jsonread.readingjsoninspringbootapp.modal.Employee;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public interface EmployeeService {
    List<Employee> getAllEmployee() throws IOException;

    List<Employee> getAllEmployeeOfPerticularCity(String city);
}

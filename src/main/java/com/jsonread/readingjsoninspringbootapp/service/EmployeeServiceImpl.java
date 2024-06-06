package com.jsonread.readingjsoninspringbootapp.service;

import com.jsonread.readingjsoninspringbootapp.modal.Employee;
import com.jsonread.readingjsoninspringbootapp.repository.EmployeeRepositoty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeRepositoty employeeRepositoty;

    @Override
    public List<Employee> getAllEmployee() throws IOException {
        List<Employee> employees = employeeRepositoty.readEmployeeFromJson();
        return employees;
    }

    @Override
    public List<Employee> getAllEmployeeOfPerticularCity(String city) {
        List<Employee> allEmployeeOfPerticularCity = employeeRepositoty.getAllEmployeeOfPerticularCity(city);
        return allEmployeeOfPerticularCity;
    }
}

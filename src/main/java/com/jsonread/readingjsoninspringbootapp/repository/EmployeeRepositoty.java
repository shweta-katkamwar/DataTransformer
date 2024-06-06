package com.jsonread.readingjsoninspringbootapp.repository;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jsonread.readingjsoninspringbootapp.modal.Employee;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class EmployeeRepositoty {

    public List<Employee> readEmployeeFromJson() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        File employeeJsonFile = new File("src/main/resources/employee.json");
//            Employee employee = objectMapper.readValue(employeeJsonFile, Employee.class);
           // List<Employee> employees = List.of(objectMapper.readValue(employeeJsonFile, Employee[].class));
            /*Employee[] employees = objectMapper.readValue(employeeJsonFile, Employee[].class);
            System.out.println(Arrays.asList(employees));*/

            List<Employee> employees = objectMapper.readValue(employeeJsonFile
                    , new TypeReference<List<Employee>>() {});
            return employees;
//            System.out.println(employees);
    }

    public List<Employee> getAllEmployeeOfPerticularCity(String city) {
        Optional<List<Employee>> optionalEmployees = Optional.empty();
        try {
            List<Employee> employees = readEmployeeFromJson();
            optionalEmployees = Optional.of(employees);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        List<Employee> filteredEmployee =
                optionalEmployees.get().stream().filter(x->x.getAddress().getCity().equalsIgnoreCase(city)).collect(Collectors.toList());
        return filteredEmployee;
    }
}

package com.jsonread.readingjsoninspringbootapp.modal;

import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
@Getter

public class Employee {
    private int id;
    private String name;
    private double salary;
    @Autowired
    Address address;

    @Override
    public String toString() {
        return "(id=" + id + ", name=" + name +", salary=" + salary + ", address=" + address + ")";
    }
}

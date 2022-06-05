package com.example.homeWorkCollections.service;

import com.example.homeWorkCollections.exceptions.EmployeeAlreadyAddedException;
import com.example.homeWorkCollections.exceptions.EmployeeNotFoundException;
import com.example.homeWorkCollections.exceptions.EmployeeStorageIsFullException;
import com.example.homeWorkCollections.model.Employee;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EmployeeService {

    private static final int LIMIT =10;


    private final List<Employee> employees = new ArrayList<>();

    public Employee add(String name, String surname) {
        Employee employee = new Employee(name, surname);
        if (employees.contains(employee)){
            throw new EmployeeAlreadyAddedException();
        }
        if (employees.size()<LIMIT){
            employees.add(employee);
            return employee;
        }
        throw new EmployeeStorageIsFullException();
    }

    public Employee remove(String name, String surname) {
        Employee employee = new Employee(name, surname);
        if (!employees.contains(employee)){
            throw new EmployeeNotFoundException();
        }
        employees.remove(employee);
        return employee;
    }

    public Employee find(String name, String surname) {
        Employee employee = new Employee(name, surname);
        if (!employees.contains(employee)){
            throw new EmployeeNotFoundException();
        }
        return employee;
    }

    public List<Employee> getAll(){
        return new ArrayList<>(employees);
    }
}

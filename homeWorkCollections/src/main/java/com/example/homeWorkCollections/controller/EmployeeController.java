package com.example.homeWorkCollections.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.homeWorkCollections.model.Employee;
import com.example.homeWorkCollections.service.EmployeeService;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/add")
    public Employee add (@RequestParam ("first name") String name,
                         @RequestParam("last name") String surname){
        return employeeService.add(name,surname);
    }

    @GetMapping("/remove")
    public Employee remove (@RequestParam ("first name") String name,
                         @RequestParam("last name") String surname){
        return employeeService.remove(name,surname);
    }

    @GetMapping("/find")
    public List<Employee> getAll(){
        return employeeService.getAll();
    }
}

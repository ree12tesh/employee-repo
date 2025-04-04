package com.example.demo.controller;


import com.example.demo.entity.Employee;
import com.example.demo.exception.EmployeeNotFoundException;
import com.example.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v2/employees")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Integer id) throws EmployeeNotFoundException {
        return ResponseEntity.ok(employeeService.getEmployeeById(id));
    }

    @GetMapping
    public ResponseEntity<List<Employee>> getALlEmployees() {
        return ResponseEntity.ok(employeeService.getAllEmployees());
    }

    @PostMapping
    public void persistEmployee(@RequestBody Employee employee) {
        employeeService.persistEmployees(employee);
    }


}

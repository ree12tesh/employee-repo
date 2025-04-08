package com.example.demo.service;

import com.example.demo.entity.Employee;
import com.example.demo.exception.EmployeeNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {

    List<Employee> employeeList = new ArrayList<>();

    public void persistEmployees(Employee employee) {
        employee.setId(employeeList.size()+1);
        employeeList.add(employee);
    }

    public Employee getEmployeeById(Integer id) throws EmployeeNotFoundException {
        for (Employee employee : employeeList) {
            if (employee.getId().equals(id)) {
                return employee;
            }
        }
        throw new EmployeeNotFoundException("Employee with ID " + id + " not found");
    }

    public List<Employee> getAllEmployees() {
        return employeeList;
    }

}

package com.application.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.application.entities.Employee; // Update import

public interface EmployeeService {
	
    public List<Employee> getEmployees(); 

    public Optional<Employee> getEmployee(int employeeId); 

    public Employee addEmployee(Employee data); 

    public Employee updateEmployee(Employee employee); 

    public boolean deleteEmployee(int employeeId); 
}

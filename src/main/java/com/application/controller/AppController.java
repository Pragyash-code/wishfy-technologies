package com.application.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.application.entities.Employee;
import com.application.exception.AppExceptionHandler;
import com.application.service.EmployeeService;

@RestController
@RequestMapping("/v1")
public class AppController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private AppExceptionHandler exceptionHandler;

    // Getting all the employees list
    @GetMapping("/allEmployee")
    public ResponseEntity<List<Employee>> getEmployees() {
        List<Employee> employees = employeeService.getEmployees();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    // API to employee info based on the employeeId
    @GetMapping("/employeeById/{employeeId}")
    public ResponseEntity<Employee> getEmployee(@PathVariable int employeeId) {
        Optional<Employee> employee = employeeService.getEmployee(employeeId);
        return employee.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // To add a new employee to the database
    @PostMapping("/addEmployee")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee data) {
        Employee newEmployee = employeeService.addEmployee(data);
        return new ResponseEntity<>(newEmployee, HttpStatus.CREATED);
    }

    // To update the info already present in the database
    @PutMapping("/updateEmployee")
    public ResponseEntity<?> updateEmployee(@RequestBody Employee employee) {
        try {
            Employee updatedEmployee = employeeService.updateEmployee(employee);
            return new ResponseEntity<>(updatedEmployee, HttpStatus.OK);
        } catch (Exception e) {
            return exceptionHandler.handleGenericException(e);
        }
    }

    // To delete the data of the employee from the database
    @DeleteMapping("/deleteEmployee/{employeeId}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable int employeeId) {
        boolean success = employeeService.deleteEmployee(employeeId);
        return success ? new ResponseEntity<>(HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}

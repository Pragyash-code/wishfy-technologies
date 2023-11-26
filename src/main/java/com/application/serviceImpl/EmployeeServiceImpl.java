package com.application.serviceImpl;

import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.dao.EmployeeDao; // Update import
import com.application.entities.Employee; // Update import
import com.application.service.EmployeeService; // Update import

// Created service as an interface and now implementing it here because we want loose coupling
@Service
public class EmployeeServiceImpl implements EmployeeService { 

    @Autowired
    private EmployeeDao employeeDao;
    
    private static final String EMAIL_REGEX =
            "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";

    private static final Pattern pattern = Pattern.compile(EMAIL_REGEX);

    public static boolean isEmailValid(String email) {
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    @Override
    public List<Employee> getEmployees() {
        try {
            return employeeDao.findAll();
        } catch (Exception e) {
            throw new RuntimeException("Error getting employees", e);
        }
    }

    @Override
    public Optional<Employee> getEmployee(int employeeId) {
        try {
            return employeeDao.findById(employeeId);
        } catch (Exception e) {
            throw new RuntimeException("Error getting employee by ID", e);
        }
    }


    @Override
    public Employee addEmployee(Employee data) {
    	if(!isEmailValid(data.getEmail())) {
    		  throw new IllegalArgumentException("Invalid email address");
    	}
    	 try {
    	        return employeeDao.save(data);
    	    } catch (Exception e) {
    	        throw new RuntimeException("Error updating employee", e);
    	    }
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        try {
            return employeeDao.save(employee);
        } catch (Exception e) {
            throw new RuntimeException("Error updating employee", e);
        }
    }

    @Override
    public boolean deleteEmployee(int employeeId) {
        try {
            employeeDao.deleteById(employeeId);
            return true; // Return true if deletion is successful
        } catch (Exception e) {
            throw new RuntimeException("Error deleting employee", e);
        }
    }

}

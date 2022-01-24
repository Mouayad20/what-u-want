package com.example.demo.services;

import com.example.demo.Models.EmployeeModel;
import com.example.demo.Repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    public ResponseEntity<Object> create(EmployeeModel employeeModel) {
        return null;

    }
}

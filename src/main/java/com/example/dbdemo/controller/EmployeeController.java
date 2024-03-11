package com.example.dbdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.dbdemo.service.EmployeeService;
import com.example.dbdemo.service.ProductService;

@RestController
public class EmployeeController {
	 @Value("${successfull.message}")
	    private String successfulMessage;
    @Autowired
    private EmployeeService employeeService;

    @PostMapping(value = "/employee/action/add")
    public ResponseEntity<?> addEmployee(@RequestParam String employeeName, @RequestParam String address, @RequestParam String phone ) {
        employeeService.addEmployee( employeeName,address,phone);
        return new ResponseEntity<>(successfulMessage, HttpStatus.OK);
    }
   
}

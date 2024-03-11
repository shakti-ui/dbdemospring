package com.example.dbdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dbdemo.dao.EmployeeDAOImpl;
import com.example.dbdemo.dao.ProductDAOImpl;
import com.example.dbdemo.dto.EmployeeDTO;
import com.example.dbdemo.dto.ProductDTO;

@Service
public class EmployeeService {

    @Autowired
private EmployeeDAOImpl employeeDAOImpl;
    public void addEmployee(String employeeName,String address, String phone) {
        EmployeeDTO employeeDTO =new EmployeeDTO();
        employeeDTO.setEmployeeName(employeeName);
        employeeDTO.setAddress(address);
        employeeDTO.setPhone(phone);
        employeeDAOImpl.addEmployee(employeeDTO);
    }
   
}

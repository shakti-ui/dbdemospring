package com.example.dbdemo.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.dbdemo.dto.EmployeeDTO;
import com.example.dbdemo.dto.ProductDTO;
@Repository
public class EmployeeDAOImpl {
	@Autowired
	private SessionFactory sessionFactory;
	public void addEmployee(EmployeeDTO employeeDTO) {
        sessionFactory.getCurrentSession().saveOrUpdate(employeeDTO);
    }
	

}

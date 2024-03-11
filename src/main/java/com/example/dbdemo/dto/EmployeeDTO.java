package com.example.dbdemo.dto;

import javax.persistence.*;

@Entity
@Table(name = "employees")
public class EmployeeDTO {

    /*
    DTO - Data transfer object, used to be passed to Hibernate Session to perform SQL operations.
     */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String employeeName;
    private String address;
    private String phone;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
    
}


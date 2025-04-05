package com.employeemanagement.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
@Entity
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private String dob;
	private String address;
	private Double salary;
	private String role;
	private String joinDate;
    private Double yearlyBonus;
    
    @ManyToOne
    @JsonBackReference
	@JoinColumn(name = "deptId", nullable = false)
	private Department department;
    
    @ManyToOne
    @JoinColumn(name = "reporting_Manager_id", nullable = true)
    private Employee reportingManager;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(String joinDate) {
		this.joinDate = joinDate;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Double getYearlyBonus() {
		return yearlyBonus;
	}

	public void setYearlyBonus(Double yearlyBonus) {
		this.yearlyBonus = yearlyBonus;
	}

	public Employee getReportingManager() {
		return reportingManager;
	}

	public void setReportingManager(Employee reportingManager) {
		this.reportingManager = reportingManager;
	}
}

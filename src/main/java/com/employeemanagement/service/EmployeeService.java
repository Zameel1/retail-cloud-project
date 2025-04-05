package com.employeemanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employeemanagement.entity.Employee;
import com.employeemanagement.repository.EmployeeRepository;
@Service
public class EmployeeService {
	@Autowired
	private EmployeeRepository employeeRepository;
	
	public List<Employee> getAllEmployee(Employee employee) {
		return employeeRepository.findAll();
	}

	public List<Employee> getEmployee() {
		return employeeRepository.findAll();
	}

	public Employee saveEmp(Employee employee) {
		return employeeRepository.save(employee);
	}

	public void deleteEmp(Integer id) {
		employeeRepository.deleteById(id);
	}

	public void updateSave(Employee employee) {
	}

	public Employee getEmpById(Integer id) {
		return employeeRepository.findById(id).orElse(null);
	}
	
	public List<Employee> getEmployeesByDepartmentId(Integer id) {
	    return employeeRepository.findByDepartmentId(id);
	}

}

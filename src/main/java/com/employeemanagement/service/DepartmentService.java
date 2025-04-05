package com.employeemanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employeemanagement.entity.Department;
import com.employeemanagement.repository.DepartmentRepository;

@Service
public class DepartmentService {
	@Autowired
	DepartmentRepository departmentRepository;

	public List<Department> getDepartment(Department department) {
		return departmentRepository.findAll();
	}

	public Department saveDepartment(Department department) {
		return departmentRepository.save(department);
	}

	public void deleteDepartment(Integer id) {
		departmentRepository.deleteById(id);

	}

	public Department getDepartmentById(Integer id) {
		return departmentRepository.findById(id).orElse(null);

	}

	public List<Department> getAllDepartment() {
		return departmentRepository.findAll();

	}
}

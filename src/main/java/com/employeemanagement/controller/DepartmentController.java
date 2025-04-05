package com.employeemanagement.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.employeemanagement.entity.Department;
import com.employeemanagement.entity.Employee;
import com.employeemanagement.service.DepartmentService;
import com.employeemanagement.service.EmployeeService;

@RestController
@RequestMapping("/api/Department")
public class DepartmentController {

	@Autowired
	private DepartmentService departmentService;
	
	@Autowired
    private EmployeeService employeeService;

	@GetMapping
	public List<Department> listAllDepartments() {
		return departmentService.getAllDepartment();
	}

	@GetMapping("/{id}")
	public Department getDeptById(@PathVariable Integer id) {
		return departmentService.getDepartmentById(id);
	}
	
	

	@PostMapping("/save/{id}")
	public Department saveDepartment(@RequestBody Department department) {
		return departmentService.saveDepartment(department);
	}

	@PutMapping("/update/{id}")
	public Department updateDepartment(@PathVariable Integer id, @RequestBody Department updatedDepartment) {
		Department existingDepartment = departmentService.getDepartmentById(id);
		if (existingDepartment != null) {
			existingDepartment.setDeptName(updatedDepartment.getDeptName());
			existingDepartment.setCreationDate(updatedDepartment.getCreationDate());
			existingDepartment.setDepartmentHead(updatedDepartment.getDepartmentHead());

			return departmentService.saveDepartment(existingDepartment);
		}
		return null;
	}

	@DeleteMapping("/{id}")
	public String deleteDepartment(@PathVariable Integer id) {
		departmentService.deleteDepartment(id);
		return "Department with ID " + id + " has been deleted";
	}

	@GetMapping("/expand/{id}")
	public Object getDepartmentWithEmployees(@PathVariable Integer id, @RequestParam(required = false) String expand) {
	    Department dept = departmentService.getDepartmentById(id);

	    if (dept == null) {
	        return "Department not found";
	    }

	    if (expand != null && expand.equalsIgnoreCase("employee")) {
	        List<Employee> employees = employeeService.getEmployeesByDepartmentId(id);

	        // Basic map-style response
	        Map<String, Object> response = new HashMap<>();
	        response.put("Department Id", dept.getId());
	        response.put("Department Name", dept.getDeptName());
	        response.put("Creation Date", dept.getCreationDate());
	        response.put("Department Head", dept.getDepartmentHead() != null ? dept.getDepartmentHead().getName() : null);
	        response.put("Employee", employees);

	        return response;
	    }

	    return dept;
	}
}

package com.employeemanagement.controller;

import com.employeemanagement.entity.Employee;
import com.employeemanagement.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")  // Base path for all endpoints
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    // Get all employees
    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployee(null);
    }

    // Get employee by ID
    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable Integer id) {
        return employeeService.getEmpById(id);
    }

    // Add a new employee
    @PostMapping("/save/{id}")
    public Employee createEmployee(@RequestBody Employee employee) {
        return employeeService.saveEmp(employee);
    }

    // Update an existing employee
    @PutMapping("/update/{id}")
    public Employee updateEmployee(@PathVariable Integer id, @RequestBody Employee updatedEmployee) {
        Employee existingEmployee = employeeService.getEmpById(id);
        if (existingEmployee != null) {
            existingEmployee.setName(updatedEmployee.getName());
            existingEmployee.setDob(updatedEmployee.getDob());
            existingEmployee.setAddress(updatedEmployee.getAddress());
            existingEmployee.setSalary(updatedEmployee.getSalary());
            existingEmployee.setRole(updatedEmployee.getRole());
            existingEmployee.setJoinDate(updatedEmployee.getJoinDate());
            existingEmployee.setYearlyBonus(updatedEmployee.getYearlyBonus());
            existingEmployee.setDepartment(updatedEmployee.getDepartment());
            existingEmployee.setReportingManager(updatedEmployee.getReportingManager());

            return employeeService.saveEmp(existingEmployee);
        }
        return null; // Or handle error properly (e.g., throw an exception)
    }

    // Delete an employee
    @DeleteMapping("/{id}")
    public String deleteEmployee(@PathVariable Integer id) {
        employeeService.deleteEmp(id);
        return "Employee with ID " + id + " has been deleted";
    }
    
    
    
}

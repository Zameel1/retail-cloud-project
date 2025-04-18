package com.employeemanagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.employeemanagement.entity.Employee;

@Repository

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	List<Employee> findByDepartmentId(Integer id);

}

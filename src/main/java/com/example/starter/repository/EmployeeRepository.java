package com.example.starter.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.starter.model.Employee;
import com.example.starter.service.EmployeeService;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{

	Employee findByEmail(String email);

//	Employee findByFirstName(String lastName);
	//Employee save(EmployeeService employee);
	
}

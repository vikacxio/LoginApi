package com.example.starter.service;

import com.example.starter.dto.ResponseDto;
import com.example.starter.dto.SignInResponseDto;
import com.example.starter.dto.user.SignInDto;
import com.example.starter.dto.user.SignUpDto;
import com.example.starter.model.Employee;

import java.security.NoSuchAlgorithmException;
import java.util.*;





public interface EmployeeService {
	Employee saveEmployee(Employee employee);
	List<Employee> getAllEmployees();
	Employee getEmployeeById(long id);
	Employee updateEmployee(Employee emoployee, long id);
	void deleteEmployee(long id);

	ResponseDto signUp(SignUpDto signupDto) throws NoSuchAlgorithmException;


	SignInResponseDto signIn(SignInDto signInDto);
}


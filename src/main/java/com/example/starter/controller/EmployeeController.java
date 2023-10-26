package com.example.starter.controller;

import java.security.NoSuchAlgorithmException;

import com.example.starter.dto.ResponseDto;
import com.example.starter.dto.SignInResponseDto;
import com.example.starter.dto.user.SignInDto;
import com.example.starter.dto.user.SignUpDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.starter.service.EmployeeService;

import javax.validation.Valid;


@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
	
	private final EmployeeService employeeService;

	public EmployeeController(EmployeeService employeeService) {
		super();
		this.employeeService = employeeService;

	}
	//create employee rest api
	//create employee rest api

	@PostMapping("/signup")
	public ResponseDto signup(@Valid @RequestBody SignUpDto signUpDto) throws NoSuchAlgorithmException {
		return employeeService.signUp(signUpDto);
	}

	@PostMapping("/signin")
	public SignInResponseDto signIn(@Valid @RequestBody SignInDto signInDto){
		return employeeService.signIn(signInDto);
	}
	
	/*
	@PostMapping()
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee){
		
		return new ResponseEntity<Employee>(employeeService.saveEmployee(employee), HttpStatus.CREATED);
		
	}
	
	//get all employee
	
	@GetMapping
	public List<Employee> getAllEmployees(){
		
		return employeeService.getAllEmployees();
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable("id")long id){
		return new ResponseEntity<Employee>(employeeService.getEmployeeById(id), HttpStatus.OK);
	}
	
	
	@PutMapping(value="{id}")
	public ResponseEntity<Employee> updadeEmployee( @RequestBody Employee employee,@PathVariable("id")long id){
		return new ResponseEntity<Employee>(employeeService.updateEmployee(employee,id), HttpStatus.OK);
	}
	
	//delete rest api
	
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable("id")long id){
		employeeService.deleteEmployee(id);
		return new ResponseEntity<String>("Deleted Successfully", HttpStatus.OK);
		
	}
	
	
	*/
	
	
	
}

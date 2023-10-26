/*package com.example.starter.controller;



import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.starter.model.Employee;

@RestController
public class RestClient {
	private static final String GET_ALL_USERS_API= "http://localhost:8080/api/employees";
	private static final String GET_USERS_BY_ID_API= "http://localhost:8080/api/employees/{id}";
	private static final String CREATE_USERS_API= "http://localhost:8080/api/employees";
	
	private static final String UPDATE_USERS_BY_ID_API= "http://localhost:8080/api/employees/{id}";
	private static final String DELETE_USERS_BY_ID_API= "http://localhost:8080/api/employees/{id}";
	
	static RestTemplate restTemplate = new RestTemplate();
	public static void main(String[] args) {
		
		callGetAllEmployeeApi();
		callEmployeeByIdAPI();
		createEmployee();
		callUpdateEmployee();
		callDeleteEmployee();
		
		
	}
	private static void callGetAllEmployeeApi() {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		
		HttpEntity<String> entity= new HttpEntity<>("parameters", headers);
		
		ResponseEntity<String> result= restTemplate.exchange(GET_ALL_USERS_API, HttpMethod.GET, entity, String.class);
		System.out.println(result);
	}
	
	
	private static void callEmployeeByIdAPI() {
		Map<String, Integer> param= new HashMap<>();
		param.put("id", 2);
		Employee employee= restTemplate.getForObject(GET_USERS_BY_ID_API, Employee.class, param);
		System.out.println(employee.getFirstName());
		System.out.println(employee.getLastName());
		System.out.println(employee.getEmail());
		
	}
	private static void createEmployee() {
		Employee employee = new Employee("Priyanka", "Kumari", "priyanka123@gmail.com", "India@123");
		ResponseEntity<Employee> userEntity =	restTemplate.postForEntity(CREATE_USERS_API, employee, Employee.class);
		System.out.println(userEntity.getBody());
	}
	
	private static void callUpdateEmployee() {
		Map<String, Integer> param= new HashMap<>();
		param.put("id", 2);
		Employee updateEmployee = new Employee("Rahul","dikshit","rahul@gmail.com","India@123");
	restTemplate.put(UPDATE_USERS_BY_ID_API, updateEmployee, param);
		
	}
	private static void callDeleteEmployee() {
		Map<String, Integer> param= new HashMap<>();
		param.put("id", 2);
		
	restTemplate.delete(DELETE_USERS_BY_ID_API, param);
		
		
	}

}*/

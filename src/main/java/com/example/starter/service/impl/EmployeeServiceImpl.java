package com.example.starter.service.impl;



import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.Optional;

import com.example.starter.dto.ResponseDto;
import com.example.starter.dto.SignInResponseDto;
import com.example.starter.dto.user.SignInDto;
import com.example.starter.dto.user.SignUpDto;
import com.example.starter.exception.AuthenticationFailException;
import com.example.starter.exception.CustomException;
import com.example.starter.model.AuthenticationToken;
import com.example.starter.service.AuthenticationService;
import org.apache.tomcat.websocket.AuthenticationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.starter.exception.ResourceNotFoundException;
import com.example.starter.model.Employee;
import com.example.starter.repository.EmployeeRepository;
import com.example.starter.service.EmployeeService;

import javax.transaction.Transactional;
import javax.xml.bind.DatatypeConverter;


@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	
	@Autowired
	private final EmployeeRepository employeeRepository;

	@Autowired
	AuthenticationService authenticationService;

	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		super();
		this.employeeRepository = employeeRepository;
	}

	@Transactional
	public ResponseDto signUp(SignUpDto signupDto)  {
		
		if(Objects.nonNull(employeeRepository.findByEmail(signupDto.getEmail()))){
			// we have an user


			ResponseDto responseDto= new ResponseDto("Failed","User Already present");
			return responseDto;
			//throw new CustomException("User Already present");
		}
//		String encryptedpassord = signupDto.getPassword();
//		try{
//			encryptedpassord=hashPassword(signupDto.getPassword());
//		} catch (NoSuchAlgorithmException e) {
//			e.printStackTrace();
//			//throw new CustomException(e.getMessage());
//		}
//		if(Objects.isNull(employeeRepository.findByFirstName(signupDto.getFirstName()))){
//			ResponseDto responseDto= new ResponseDto("Failed","First name cannot be empty");
//			return responseDto;
//		}




		Employee employee = new Employee(signupDto.getFirstName(), signupDto.getLastName(),signupDto.getEmail(),signupDto.getPassword());
		employeeRepository.save(employee);


		//save user
		//create token

		final AuthenticationToken authenticationToken=new AuthenticationToken(employee);
		authenticationService.saveConfirmationToken(authenticationToken );
		ResponseDto responseDto= new ResponseDto("Success","User created!");
		return responseDto;

	}

//	private String hashPassword(String password) throws NoSuchAlgorithmException {
//		MessageDigest md= MessageDigest.getInstance("MD5");
//		md.update(password.getBytes(StandardCharsets.UTF_8));
//		byte[] digest = md.digest();
//		String hash= DatatypeConverter.printHexBinary(digest).toUpperCase();
//		return hash;
//	}


	public SignInResponseDto signIn (SignInDto signInDto){

		//find user by email
		Employee employee = employeeRepository.findByEmail(signInDto.getEmail());
		if(Objects.isNull(employee)){


			return new SignInResponseDto("Failed","User is invalid");

		//	throw new AuthenticationFailException("user is invalid");
		}

		//not using the hashing for the authentication
		// if we use the authentication for the setup we can have the prompt
		
		if(!employee.getPassword().equals(signInDto.getPassword())){
//			System.out.println(employee.getPassword());
//			System.out.println(signInDto.getPassword());

			return new SignInResponseDto("Failed","Wrong password");
			//throw new AuthenticationFailException("wrong password");
		}//


		//hash the password

		//if password match


		AuthenticationToken token = authenticationService.getToken(employee);
		if(Objects.isNull(token)){
			throw new CustomException("token is not present");
		}
		return new SignInResponseDto("success","User logged in!" ,token.getToken());



		// retrieve the token

		//return response

	}
	@Override
	public Employee saveEmployee(Employee employee) {
		
		return 	employeeRepository.save(employee);
	}

	@Override
	public List<Employee> getAllEmployees() {
		
		return employeeRepository.findAll();
	}

	@Override
	public Employee getEmployeeById(long id) {
		Optional<Employee> employee = employeeRepository.findById(id);
		
		if(employee.isPresent()) {
			return employee.get();
		}
		else {
			throw new ResourceNotFoundException("Employee","Id",id);
		}		
		//return employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee", "Id", id));		
	}

	@Override
	public Employee updateEmployee(Employee employee, long id) {
		
		//check whether employee with given id is exists in database or not
		
		Employee existEmployee = employeeRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Employee", "Id", id));
				
		existEmployee.setFirstName(employee.getFirstName());
		existEmployee.setLastName(employee.getLastName());
		existEmployee.setEmail(employee.getEmail());
		existEmployee.setPassword(employee.getPassword());

		
		employeeRepository.save(existEmployee);
		return existEmployee;
	}

	@Override
	public void deleteEmployee(long id) {
		Optional<Employee> employee = employeeRepository.findById(id);
		if(employee.isPresent()) {
		employeeRepository.deleteById(id);
		}
		else {
			throw new ResourceNotFoundException("Employee", "Id", id);
		}
	}

}

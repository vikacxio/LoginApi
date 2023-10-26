package com.example.starter.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.*;


@Entity
@Table(name="employees")
public class Employee {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;



	@NotEmpty(message = "First name cannot be empty")
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;


	@Pattern(regexp = "^[a-zA-Z0-9_+&*-]+(?:\\."+
			"[a-zA-Z0-9_+&*-]+)*@" +
			"(?:[a-zA-Z0-9-]+\\.)+[a-z" +
			"A-Z]{2,7}$", message = "Email is not correct")
	@Column(name="email")
	private String email;



	//@Pattern(regexp = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{8,20}$", message = "Use strong password")



	private String password;


	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	public Employee( String firstName, String lastName, String email, String password) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password= password;
	}
	public Employee() {

	}


}

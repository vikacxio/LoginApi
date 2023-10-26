package com.example.starter.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String resourceNameString;
	private String fieldName;
	private Object fieldValue;
	public ResourceNotFoundException(String resourceNameString, String fieldName, Object fieldValue) {
		super(String.format("%s not found with %s : '%s'",resourceNameString, fieldName,fieldValue));
		this.resourceNameString = resourceNameString;
		this.fieldName = fieldName;
		this.fieldValue = fieldValue;
	}
	public String getResourceNameString() {
		return resourceNameString;
	}
	public String getFieldName() {
		return fieldName;
	}
	public Object getFieldValue() {
		return fieldValue;
	}
}

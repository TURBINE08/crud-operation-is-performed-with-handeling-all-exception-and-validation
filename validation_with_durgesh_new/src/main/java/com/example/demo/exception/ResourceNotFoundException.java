package com.example.demo.exception;

import lombok.Getter;
import lombok.Setter;

@SuppressWarnings("serial")
@Getter 
@Setter
public class ResourceNotFoundException extends RuntimeException
{ 

	String resourceName;
	String FieldName;
	Integer fieldValue;
	public ResourceNotFoundException(String resourceName, String fieldName, Integer Id) 

//	public ResourceNotFoundException(String resourceName, String fieldName, String name) 

	{
		super(String.format("%s not is not exit %s : %s", resourceName, fieldName,Id));
		this.resourceName = resourceName;
		this.FieldName = fieldName;
		this.fieldValue = Id;
		
	}
	
}



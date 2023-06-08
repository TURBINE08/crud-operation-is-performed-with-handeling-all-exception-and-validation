package com.example.demo.exception;

import lombok.Getter;
import lombok.Setter;

@Getter 
@Setter
@SuppressWarnings("serial")
public class ResourceNotFoundExceptions extends RuntimeException
{
	String resourceName;
	String FieldName;
	Integer fieldValue;
	public ResourceNotFoundExceptions(String resourceName, String fieldName, Integer Id) 

//	public ResourceNotFoundException(String resourceName, String fieldName, String name) 

	{
		super(String.format("%s is not exist with name %s : %s", resourceName, fieldName,Id));
		this.resourceName = resourceName;
		this.FieldName = fieldName;
		this.fieldValue = Id;
		
	}

}

package com.example.demo.payloads;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Login 
{

	@NotNull
	@Size(min = 4, message = "Username must be min of 4 character !! ")
	private String name;
	
	@NotNull
	@Size(min = 4, max = 8, message = "password must be in the min 3 and max 8 character")
	private String password;
} 

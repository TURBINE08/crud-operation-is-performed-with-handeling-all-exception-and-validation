package com.example.demo.payloads;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

//import org.springframework.validation.annotation.Validated;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@NoArgsConstructor
@Getter
@Setter
//@Validated
public class UserDto 
{

	private int id;
	
	@NotNull
	@Size(min = 4, message = "Username must be min of 4 character !! ")
//	@NotEmpty(message = "You must have to enter your name")
//	private String name;
	
	public String name ;
	
	@Email(message = "Email address is not valid !! ")
//	@NotEmpty(message = "this field is required")
//	@NotEmpty(message = "please enter your correct Email")
	private String email;
	
	@NotNull
	@Size(min = 4, max = 8, message = "password must be in the min 3 and max 8 character")
//	@Pattern(regexp=" [A-Z][a-z]*[0-9][a-z]", message = "enter correct password pattern one"
//			+ " upper case and one lower case and one number is required")
	private String password;
	
	@NotEmpty
//	@NotEmpty(message = "about field is required")
	private String about;
	
}

package com.example.demo.entites;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class User 
{

	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private int id;
	
//	@NotNull(message = "enter your user name")
	private String name;
//	@Email
	private String email;
//	@NotNull
	private String password;
//	@NotNull
	private String about;
}

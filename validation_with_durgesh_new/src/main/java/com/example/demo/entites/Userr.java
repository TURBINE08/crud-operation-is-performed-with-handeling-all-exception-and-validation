package com.example.demo.entites;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Userr

{

	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private int id;
	
//	@NotNull(message = "enter your user name")
//	@Column(name = "user_name", nullable = false, length = 100)
	private String name;
//	@Email
	private String email;
//	@NotNull
	private String password;
//	@NotNull
	private String about;
	
//	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY )
//	private List<Role> post = new ArrayList<>();
//	
//	@ManyToMany
//	@JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user" , referencedColumn))
//	private Set<Role> roles = new HashSet<>();
}

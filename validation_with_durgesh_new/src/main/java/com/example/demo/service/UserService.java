package com.example.demo.service;

import java.util.List;

//import com.example.demo.entites.User;
import com.example.demo.entites.Userr;
import com.example.demo.payloads.Login;
import com.example.demo.payloads.UserDto;

public interface UserService 
{
 
//	UserDto login(UserDto userDto);
	UserDto createUser(UserDto userDto);
	UserDto updateUser(UserDto user,Integer userId);
	UserDto getUserById(Integer userId);
	List<UserDto> getAlluser();
	void deleteUser(Integer userId);
	Userr loginn (Login login);

	
	
	
	
}
  
//package com.example.demo.service.impl;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.example.demo.check.Check;
//import com.example.demo.entites.User;
//import com.example.demo.exception.ResourceNotFoundException;
//import com.example.demo.payloads.UserDto;
//
//
//
//@Service
//public class checkImpl 
//{
//
//	@Autowired
//	private Check check;
//
//	public User chk(UserDto userDto) 
//	{
//		User userrr = this.check.findByName(userDto.getName()).orElseThrow           
//				(()-> new ResourceNotFoundException("User allready exist",userDto.getName(),4));
//		
//		
//		return userrr;
//	}  
//	
////	@Autowired
////	private UserServiceImpl userServiceImpl; 
//	
//	
//	
//	
//}

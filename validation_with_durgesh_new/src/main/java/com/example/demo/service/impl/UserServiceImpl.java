package com.example.demo.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import com.example.demo.exception.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import com.example.demo.check.Check;
import com.example.demo.entites.Userr;
import com.example.demo.payloads.Login;
import com.example.demo.payloads.UserDto;
import com.example.demo.repository.UserRepo;
//import com.example.demo.service.Userr;
import com.example.demo.service.UserService;
@Service
public class UserServiceImpl implements UserService
{
	
//	@Autowired
//	private checkImpl checkimpl;

	
	@Autowired
	private UserRepo userRepo; 
//	private Check check;
	@Autowired
	private ModelMapper modelMapper;
	
//**********************************************************************************************************

//	@Override
//	public User loginn(Login login) {
//		
//		User user = userRepo.findByName(login.getName());
//		System.err.println(user.getName());
//		System.err.println(user.getPassword());
//		if((login.getName().equals(user.getName())&&(login.getPassword().equals(user.getPassword()))))
//		{
//			return user;
//		}
//		else
//		{
//			new ResourceNotFoundExceptions("User",login.getName(),4);
//		}
//		userRepo.existsById(null)
////		return user;
//		
		
//	}
	
	
//	@Override
//	public UserDto createUser(UserDto userDto)
//	{			
//		
////		User udr = checkimpl.chk(userDto);
//		
//		User userrr = userRepo.findByName(userDto.getName()).orElseThrow           
//				(()-> new ResourceNotFoundExceptions("User",userDto.getName(),4));
////		User userr = this.dtoToUser(udr);
//
//		User savedUser = userRepo.save(userrr);
//		
//		return this.userToDto(savedUser);
//	}
	
	
	
	
//	@Override
//	public User login(Login login) 
//	{
//		
//		
//		
//		
//		
//		User user = userRepo.findByName(login.getName()).orElseThrow           
//				(()-> new ResourceNotFoundExceptions("User",login.getName(),4));
//		
//	return user;
		
//		userRepo.findByPassword(user.getPassword()).orElseThrow           
//		(()-> new ResourceNotFoundExceptions("User",login.getName(),4));
		
		
		
//User savedUser = userRepo.save(userrr);
		
//		return this.userToDto(savedUser);
//	}
	
	
	
//*************************************************************************************************	
	@Override
	public UserDto createUser(UserDto userDto)
	{			
		Userr use = this.dtoToUser(userDto);

		
		Userr savedUser = userRepo.save(use);
		
		return this.userToDto(savedUser);
	}
	 
//**********************************************************************************************************

	@Override
	public UserDto updateUser(UserDto userDto, Integer userId) {
		Userr user = this.userRepo.findById(userId).orElseThrow
				(()-> new ResourceNotFoundException("User","Id",userId));
		user.setName(userDto.getName());
		user.setEmail(userDto.getEmail());
		user.setPassword(userDto.getPassword());
		user.setAbout(userDto.getAbout());

		Userr updateUser = this.userRepo.save(user);
		UserDto userDto1 = this.userToDto(updateUser);
		return userDto1;
	} 
	
//**********************************************************************************************************
	

	@Override
	public UserDto getUserById(Integer userId) {
		Userr user = this.userRepo.findById(userId).orElseThrow           
				(()-> new ResourceNotFoundException("User","Id",userId));
		
		
		
		
		return this.userToDto(user);
	}

//**********************************************************************************************************
	
	@Override
	public List<UserDto> getAlluser() {
		List<Userr> users = this.userRepo.findAll();
		List<UserDto>userDtos =  users.stream().map(userr-> this.userToDto(userr)).collect(Collectors.toList());
		return userDtos;
	}

//**********************************************************************************************************
	
	@Override
	public void deleteUser(Integer userId) {
	Userr user = this.userRepo.findById(userId).orElseThrow
				(()-> new ResourceNotFoundException("User","Id",userId));
		this.userRepo.delete(user);
		
	}

//**********************************************************************************************************

	private Userr dtoToUser (UserDto userDto)
	{
		Userr user = this.modelMapper.map(userDto, Userr.class);
		
		return user;
	}
	
	
	
	public UserDto userToDto(Userr user)
	{
		UserDto userDto = this.modelMapper.map(user, UserDto.class);
		return userDto;
	}

	@Override
	public Userr loginn(Login login) {
		// TODO Auto-generated method stub
		return null;
	}

	



	



	
	
//	private User dtoToUser (UserDto userDto)
//	{
//		User user = new User();
//		user.setId(userDto.getId());
//		user.setName(userDto.getName());
//		user.setEmail(userDto.getEmail());
//		user.setAbout(userDto.getAbout());
//		user.setPassword(userDto.getPassword());
//		return user;
//	}
//
//	public UserDto userToDto(User user)
//	{
//		UserDto userDto = new UserDto();
//		userDto.setId(user.getId());
//		userDto.setName(user.getName());
//		userDto.setEmail(user.getEmail());
//		userDto.setAbout(user.getAbout());
//		userDto.setPassword(user.getPassword());
//		return userDto;
//	}
	
}

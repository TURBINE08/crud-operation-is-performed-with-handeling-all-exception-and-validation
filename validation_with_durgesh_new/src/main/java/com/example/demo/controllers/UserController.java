package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
//import java.util.Map;
import java.util.Map;

import javax.validation.Valid;

//import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
//import org.springframework.security.core.userdetails.User;
import com.example.demo.entites.Userr;
import com.example.demo.exception.ResourceNotFoundExceptions;
import com.example.demo.jwtimpl.Jwtimplemnt;
import com.example.demo.payloads.ApiResponse;
import com.example.demo.payloads.Login;
import com.example.demo.payloads.UserDto;
import com.example.demo.repository.UserRepo;
import com.example.demo.service.UserService;
import com.example.demo.service.impl.UserServiceImpl;
import com.example.demo.util.JwtUtil;
//@Validated

@RestController
//@RequestMapping("/api/users")
public class UserController  
{ 
	@Autowired
	private UserService userService;
	@Autowired
	private UserRepo usrrepo1;
	@Autowired
	private Login login;
	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private Jwtimplemnt iwtimplemnt;
	@Autowired
	private JwtUtil jwtUtil;
	
	
	@PostMapping("/login" )
	public ResponseEntity<?> loginf( @Valid @RequestBody Login loginp) throws Exception
	{
		
//		if(usrrepo1.existsByNameAndPassword(login.getName(),login.getPassword()))
//		{
//			return new ResponseEntity<>(new ApiResponse
//					(" Login is Successfully ","done", true), HttpStatus.OK);
//		}
//		else {
//			return new ResponseEntity<>(new ApiResponse
//					(" Login is  not Successfully ","sorry", true), HttpStatus.OK);
//			
//		}
		
		
		
		
		
		
		if (usrrepo1.existsByNameAndPassword(login.getName(), login.getPassword())) 
		{

			//if (testRepo.existsByPasswordAndUsername(jwtRequest.getPassword(), jwtRequest.getUsername())) {
				Map<String, Object> map = new LinkedHashMap<>();
				try {
					this.authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
							login.getName(), login.getPassword()));
 
				} catch (UsernameNotFoundException e) {
					throw new Exception("Bad credentials");
				} catch (BadCredentialsException e) {
					throw new Exception("Bad credentials");

				}
				UserDetails userdetails = this.iwtimplemnt.loadUserByUsername(login.getName());

				final String token = this.jwtUtil.generateToken(userdetails);

				map.put("Status", "true");
				map.put("message", "login successfully");
				map.put("your token is:", token);
				return new ResponseEntity<>(map, HttpStatus.ACCEPTED);

				// return new ResponseEntity(new JwtResponse(token));
			}	else	
		{
		Map<String, String> map = new LinkedHashMap<>();
		map.put("Status", "fail");
		map.put("message", "enter wrong  username or password ");
		return new ResponseEntity<>(map, HttpStatus.BAD_REQUEST);}
		
		
		
		
		
		
		 
//		UserDto createUserDto = this.userService.login(userDto);
//		  User user = this.userService.loginn(login);
		  
//		  User userr = user.findByName(login.getName()).orElseThrow           
//					(()-> new ResourceNotFoundExceptions("User",login.getName(),4));
//		 
//		return new ResponseEntity<>(createUserDto,HttpStatus.ACCEPTED);
		
//		return new ResponseEntity<>(new ApiResponse
//				(" Login is Successfully ","done", true), HttpStatus.OK);
	}
	
	
	
	
	
	
	
	
//	
//private boolean usrrepo.existsByUsernameAndPassword(String name, String password) {
//		// TODO Auto-generated method stub
//		return false;
//	}









//===============================================================================================================	
	// POST- CREATE USER
	@PostMapping("/postt" )
	public ResponseEntity<UserDto> createUser( @Valid @RequestBody UserDto userDto)
	{
		UserDto createUserDto = this.userService.createUser(userDto);
		
		return new ResponseEntity<>(createUserDto,HttpStatus.CREATED);
	} 
	
	
	
//===============================================================================================================	
	// PUT - USERUPDATE
	@PutMapping("/{userId}")
	public ResponseEntity<UserDto> updateUser(@Valid @RequestBody UserDto userDto, @PathVariable("userId") Integer uId)
	{ 
		UserDto updatedUser = this.userService.updateUser(userDto,uId);
//		return new  ResponseEntity.ok(updatedUser);
//		return new ResponseEntity<>(updatedUser,HttpStatus.OK);
		return ResponseEntity.ok(updatedUser);
		
	}
	
	
	
//===============================================================================================================	
	//DELETE - delete user
	
@DeleteMapping("/{userId}")
public ResponseEntity<?> deleteUser(@PathVariable("userId") Integer uid)
{
		this.userService.deleteUser(uid);
//		return new ResponseEntity(Map.of("message","user Deleted successfully"), HttpStatus.OK);
		return new ResponseEntity<ApiResponse>
		(new ApiResponse("user deleted sccessfully","done", true), HttpStatus.OK);
		
}



//===============================================================================================================	
		//GET - get all user
	
@GetMapping("/getall")
public ResponseEntity<List<UserDto>> getAllUser()
{
	return ResponseEntity.ok(this.userService.getAlluser());
}



//===============================================================================================================	
		//GET - get single user

@GetMapping("/{userId}") 
public ResponseEntity<UserDto> getsingleUser (@PathVariable Integer userId)
{
	return ResponseEntity.ok(this.userService.getUserById(userId));
}



//================================================================================================================
//from   jwt 




//@Override
//public User loadUserByUsername(String username) throws UsernameNotFoundException {
//	Userr userss = usrrepo1.findByName(username);
//	if(userss == null)
//	{
//		throw new UsernameNotFoundException("user not found exception"+username);
//	}
//	return new User(userss.getName(),userss.getPassword(), new ArrayList<>());
//}
//	
	 

//================================================================================================================


	
}

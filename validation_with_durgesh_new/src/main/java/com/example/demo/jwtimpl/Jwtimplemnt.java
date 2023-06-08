package com.example.demo.jwtimpl;

import java.util.ArrayList;

//import org.apache.catalina.User;
import org.springframework.security.core.userdetails.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.demo.entites.Userr;
import com.example.demo.repository.UserRepo;

//@Component
@Service
public class Jwtimplemnt implements UserDetailsService
{

	@Autowired
	private UserRepo usrrepo1;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Userr userss = usrrepo1.findByName(username);
		if(userss == null)
		{
			throw new UsernameNotFoundException("user not found exception"+username);
		}
		return new User(userss.getName(),userss.getPassword(), new ArrayList<>());
		
		}

}

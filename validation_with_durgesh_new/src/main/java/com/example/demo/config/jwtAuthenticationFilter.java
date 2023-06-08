package com.example.demo.config;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.example.demo.jwtimpl.Jwtimplemnt;
import com.example.demo.util.JwtUtil;

@Component
public class jwtAuthenticationFilter extends OncePerRequestFilter 
{
	
	@Autowired
	private JwtUtil jwtUtil;
	@Autowired
	private Jwtimplemnt jwtimplemnt;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException 
	{
		final String requestToTokenHeader = request.getHeader("Authorization");
		String username = null;
		String jwtToken = null;
		 
		if(requestToTokenHeader !=null && requestToTokenHeader.startsWith("Bearer "))
		{
			jwtToken= requestToTokenHeader.substring(7);
			
			try
			{
				username  = this.jwtUtil.getUserNameFromToken(jwtToken);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
			UserDetails userdetails  = this.jwtimplemnt.loadUserByUsername(username);
			if(username!=null && SecurityContextHolder.getContext().getAuthentication()==null)
			{
				UsernamePasswordAuthenticationToken ob = new UsernamePasswordAuthenticationToken(userdetails,null,userdetails.getAuthorities());
				ob.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				SecurityContextHolder.getContext().setAuthentication(ob);
			}
			else
			{
				System.out.println("token is not valid");
			}
		}
		
		filterChain.doFilter(request, response);
		
		
	}

}

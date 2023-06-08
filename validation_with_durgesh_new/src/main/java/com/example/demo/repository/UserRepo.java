package com.example.demo.repository;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
//import com.example.demo.entites.User;
import com.example.demo.entites.Userr;
//import com.example.demo.model.CandyModel;
public interface UserRepo extends JpaRepository<Userr, Integer>
{
	
	Userr findByName(String name);
	Optional<Userr> findByPassword(String password);
	boolean existsByNameAndPassword(String Name, String Password); 
	
}

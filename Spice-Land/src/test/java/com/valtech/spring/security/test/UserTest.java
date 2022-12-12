package com.valtech.spring.security.test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;



import static org.junit.jupiter.api.Assertions.*;
import com.valtech.spring.security.entity.User;
import com.valtech.spring.security.service.UserDetailsService;

@SpringBootTest
public class UserTest {
	
	@Autowired
	UserDetailsService service;
	
	
	
	@Test
	public void userTest(){
		
		User user =new User("akshay_kumar", "a@gmail.com", "akshay_kumar", "12345", "12345", "Mysore", "9638562642", true, "ADMIN");
		
		if(user.getUsername().equals(service.findUser(user.getUsername()))){
			System.out.println("USER ALREDY EXIST");
			
		}
		
		else{
		service.createUser(user);
		System.out.println("NEW USER CREATED");
		User u= service.findentierUser(user.getUsername());
		
		assertEquals(user.getUsername(), u.getUsername());
		assertEquals(user.getName(), u.getName());
		assertEquals(user.getEmail(), u.getEmail());
		assertEquals(user.getUsername(), u.getUsername());
		assertEquals(user.getAddress(), u.getAddress());
		assertEquals(user.getRole(), u.getRole());
		}
		//service.resetUser();
		
	}

}

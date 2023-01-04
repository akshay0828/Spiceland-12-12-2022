package com.valtech.spring.security.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.valtech.spring.security.dao.UserDetailsDao;
import com.valtech.spring.security.entity.User;
import com.valtech.spring.security.service.UserDetailsService;

@SpringBootTest
public class UserTest {

	@Autowired
	UserDetailsService service;
	
	

	@Test
	public void userTest() {

		User user = new User("akshay_kumar", "a@gmail.com", "akshay_kumar", "12345", "#12a", "jayanagara", "banglore",
				"123456", "9638562642", true, "ADMIN", null);

		if (user.getUsername().equals(service.findUser(user.getUsername()))) {
			System.out.println("USER ALREDY EXIST");

		}

		else {
			service.createUser(user);

			System.out.println("NEW USER CREATED");

			User u = service.findentierUser(user.getUsername());

			assertEquals(user.getUsername(), u.getUsername());

			assertEquals(user.getRole(), u.getRole());
		}

	}

	@Test
	public void updateUser() {

		User user = service.findentierUser("akshay_kumar");

		service.updateUser("AKSHAY", "AKSHAY@GMAIL.COM", "9686083306", "MYSORE", "MYSORE", "MYSORE", "570001",
				user.getId());

		assertEquals(user.getName(), "AKSHAY");
	}

}

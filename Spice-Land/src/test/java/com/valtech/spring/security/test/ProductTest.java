package com.valtech.spring.security.test;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.valtech.spring.security.entity.Products;
import com.valtech.spring.security.entity.User;
import com.valtech.spring.security.service.ProductService;
import com.valtech.spring.security.service.UserDetailsService;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

@SpringBootTest

public class ProductTest {

	@Autowired
	private ProductService product;

	@Autowired
	private UserDetailsService service;

	@Test
	public void TestAddProducts() {
		User user = new User("akshay_kumar", "a@gmail.com", "akshay_kumar", "12345", "#12a", "jayanagara", "banglore",
				"123456", "9638562642", true, "ADMIN", null);

		if (user.getUsername().equals(service.findUser(user.getUsername()))) {
			System.out.println("USER ALREDY EXIST");

		}

		else {
			service.createUser(user);
		}
		User u = service.findentierUser("akshay_kumar");
		Products products = new Products("Dairymilk", 10, 100, "choclate", 100, "img");

		System.out.println("NEW PRODUCT ADDED");
		// product.createProduct(products);

		List<Products> p = product.getAllproductsbyuser(products.getUser());

		System.out.println(p.size());

		for (Products prod : p) {
			System.out.println("USER_ID CHECKED");
			System.out.println(prod.getUser());

			assertEquals(products.getUser(), prod.getUser());
		}

	}

}

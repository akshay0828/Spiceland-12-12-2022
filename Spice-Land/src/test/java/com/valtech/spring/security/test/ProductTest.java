package com.valtech.spring.security.test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.valtech.spring.security.entity.CartLine;
import com.valtech.spring.security.entity.Products;
import com.valtech.spring.security.service.ProductService;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class ProductTest {
	
	@Autowired
	private ProductService product;
	
	@Test
	public void TestAddProducts(){
	
		Products products=new  Products("Dairymilk", 10, 100, "choclate", 100,"img", 2);
		System.out.println("NEW PRODUCT ADDED");
	//	product.createProduct(products);
		
		List<Products> p =product.getAllproductsbyuser(products.getUserid());
		
System.out.println(p.size());

		for (Products prod : p) {
			System.out.println("USER_ID CHECKED");
			System.out.println(prod.getUserid());
			
		assertEquals(products.getUserid(), prod.getUserid());
		}
		
	}
	

}

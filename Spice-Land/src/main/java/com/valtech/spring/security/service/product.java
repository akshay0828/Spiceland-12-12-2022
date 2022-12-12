package com.valtech.spring.security.service;

import java.util.List;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.valtech.spring.security.entity.Products;

public interface product {

	void createProduct(Products products);

	Products getProduct(int id);

	List<Products> getAllProducts();

	Products updateProduct(Products product);

	int getuserid(int id);

	List<Products> getAllproductsbyuser(int userid);

	void deleteProduct(int id);
	
	

}
package com.valtech.spring.security.service;

import java.util.List;

import com.valtech.spring.security.entity.Products;
import com.valtech.spring.security.entity.User;

public interface ProductService {

	void createProduct(Products products);

	Products getProduct(int id);

	List<Products> getAllProducts();

	Products updateProduct(Products product);

	User getuserbyid(int id);

	List<Products> getAllproductsbyuser(User user);

	void deleteProduct(int id);

	List<Products> getProductsbyproductname(String productName);

	List<Integer> getuseridbyproductname(String productName);

	void productUpdate(String productName, Double price, Float weight, int quantity, String productDescription, int id)
			throws Exception;

	List<Products> searchForProduct(String search);
	


}
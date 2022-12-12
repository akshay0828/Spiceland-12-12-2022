package com.valtech.spring.security.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.valtech.spring.security.entity.Products;

import com.valtech.spring.security.repo.ProductRepository;

@Service
public class ProductService implements product {

	@Autowired
	private ProductRepository productRepository;

	// To create the new product.
	@Override
	public void createProduct(Products products) {

		productRepository.save(products);
	}

	// Details of the product by id.
	@Override
	public Products getProduct(int id) {
		return productRepository.findById(id);
	}

	// List of all products.
	@Override
	public List<Products> getAllProducts() {
		return productRepository.findAll();
	}

	// To update the existing product.
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public Products updateProduct(Products product) {
		return productRepository.save(product);
	}

	// List of products by the seller id .
	@Override
	public List<Products> getAllproductsbyuser(int userid) {
		return productRepository.findByUserid(userid);
	}

	// To get the seller id by the product id added by the seller.
	@Override
	public int getuserid(int id) {
		return productRepository.findUseridById(id);
	}

	// To delete the product.
	@Override
	public void deleteProduct(int id) {
		productRepository.deleteById(id);
	}

}

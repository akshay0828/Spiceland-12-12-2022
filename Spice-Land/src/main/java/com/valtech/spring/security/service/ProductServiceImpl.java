package com.valtech.spring.security.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.valtech.spring.security.dao.ProductDao;
import com.valtech.spring.security.entity.Products;
import com.valtech.spring.security.entity.User;
import com.valtech.spring.security.repo.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private ProductDao productdao;

	// private static final Logger logger =
	// LoggerFactory.getLogger(ProductServiceImpl.class);

	private static final Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);
	
	@Override
	public void  productUpdate(String productName,Double price,Float weight,int quantity,String productDescription,int id) throws Exception {
		
		productdao.productUpdateDao(productName, price, weight, quantity, productDescription, id);
		
		
		
	}
	

	// To create the new product.
	@Override
	public void createProduct(Products products) {
		logger.info("creating new product");
		productRepository.save(products);
	}

	// Details of the product by id.
	@Override
	public Products getProduct(int id) {
		logger.info("Fetching product with id " + id);
		Products p = productRepository.findById(id);
		logger.debug("Product with id = " + id + " is " + p);
		return p;

	}

	// List of all products.
	@Override
	public List<Products> getAllProducts() {

		logger.info("loading all products");
		List<Products> prods = productRepository.findAll();
		logger.info("loaded" + prods.size() + " products");
		logger.debug("products are " + prods);
		return prods;
	}
	// To delete the product.
		@Override
		public void deleteProduct(int id) {
			productdao.deleteProductDao(id);
		}
		
		@Override
		public List<Products> searchForProduct(String search) {
			
		return 	productdao.searchForProductDao(search);
		}

	// To update the existing product.
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public Products updateProduct(Products product) {
		logger.info("updating Existing product");
		Products p = productRepository.save(product);
		logger.debug("Product updated with id = " + product.getId() + " is " + p);
		return p;

	}

	// List of products by the seller id .
	@Override
	public List<Products> getAllproductsbyuser(User user) {
		logger.info("Listing of products through seller ");
		return productRepository.findByUser(user);
	}

	// To get the seller id by the product id added by the seller.
	@Override
	public User getuserbyid(int id) {
		logger.info("Getting seller details by product id");
		return productRepository.findUserById(id);
	}

	@Override
	public List<Products> getProductsbyproductname(String productName) {

		return productRepository.findByproductName(productName);
	}

	@Override
	public List<Integer> getuseridbyproductname(String productName) {

		return productRepository.findUseridByproductName(productName);
	}

}

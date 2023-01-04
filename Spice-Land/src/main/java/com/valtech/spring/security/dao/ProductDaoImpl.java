package com.valtech.spring.security.dao;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.valtech.spring.security.entity.Products;

@Component
public class ProductDaoImpl implements ProductDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private static final Logger logger = LoggerFactory.getLogger(ProductDaoImpl.class);

	@Override
	public void productUpdateDao(String productName, Double price, Float weight, int quantity, String productDescription,
			int id) throws Exception {
		logger.info("Updating password with JDBC Query");
		String sql = "update products set PRODUCT_NAME = ? ,price= ?, weight= ?, quantity= ?, PRODUCT_DESCRIPTION=? where id = ?";

		jdbcTemplate.update(sql, productName, price, weight, quantity, productDescription, id);

	}

	@Override
	public void deleteProductDao(int id) {
		logger.info("Deleting product");
		String sql = "delete products where id = ?";
		jdbcTemplate.update(sql, id);
	}

	@Override
	public List<Products> searchForProductDao(String search) {

		String sql = "SELECT * FROM products p WHERE UPPER(p.product_name) LIKE UPPER('" + search + "%')";

		List<Products> product = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Products.class));
		// productRepository.searchProducts(search);

		return product;
	}

}

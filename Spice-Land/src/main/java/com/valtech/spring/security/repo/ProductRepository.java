package com.valtech.spring.security.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.valtech.spring.security.entity.Products;
import com.valtech.spring.security.entity.User;

@Repository
public interface ProductRepository extends JpaRepository<Products, Integer> {
	Products findById(int id);

	List<Products> findByUser(User user);
	User findUserById(int id);

	List<Products> findByproductName(String productName);
	
	List<Integer> findUseridByproductName(String productName);
	
	Products findByIdAndUser(int id,User user);
	
	/*@Query("SELECT product_name FROM products p WHERE UPPER(p.product_name) LIKE UPPER('search%')")
	List<Products> searchProducts(@Param("search") String search);*/
	
}

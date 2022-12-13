package com.valtech.spring.security.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.valtech.spring.security.entity.Products;
import com.valtech.spring.security.entity.User;



@Repository
public interface UserReopsitory  extends JpaRepository<User, Integer>{
	
	User findByUsername(String username);
	
	User findUsernameById(int id);
	
	User findRolenameByUsername(String username);
	
	User findById(int id);
	
	List<User> findByRole(String role);
	
	User findUserByUsername(String username);

	User findByEmail(String email);

}

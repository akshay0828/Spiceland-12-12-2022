package com.valtech.spring.security.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.valtech.spring.security.entity.Role;


public interface Rolerepo extends JpaRepository<Role, Integer> {

	
	Role findByName(String name);
}

package com.valtech.spring.security.service;

import java.util.List;

import com.valtech.spring.security.entity.Role;

public interface RoleService {

	<S extends Role> S save(S entity);

	List<Role> findAll();

	void delete(Role entity);

	Role getById(Integer id);

	Role getbyName(String name);

}
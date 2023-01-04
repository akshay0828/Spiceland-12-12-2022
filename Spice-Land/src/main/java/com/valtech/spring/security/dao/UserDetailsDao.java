package com.valtech.spring.security.dao;

public interface UserDetailsDao {

	void forgotPasswordDao(String username, String password) throws Exception;

	void updateUserDao(String name, String email, String contact, String street, String area, String city, String pincode,
			int id);

}
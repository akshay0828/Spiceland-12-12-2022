package com.valtech.spring.security.service;

import java.util.List;

import com.valtech.spring.security.entity.User;

public interface UserDetailsService {

	// To delete details of all users.
	void resetUser();

	// Create the new user.
	void createUser(User user);

	// To find whether user of that username is already register or not.
	int LoginValidator(String username);

	// To get the roles of the user(admin,user,delivery person).
	String getrole(String username);

	// To get the id of that username.
	int getId(String username);

	// To get username by the id.
	User getUsername(int id);

	// Find whether user of that username is already register or not.
	String findUser(String username);

	// To get the details of the user by username.
	User findentierUser(String username);

	// Find password of the user by username.
	String findUserPass(String username);

	// Details of the user by id.
	User getuser(int id);

	// To update the details of the user.
	User updateUser(User user);

	// List of the user by role.
	List<User> getAlluser();

	// Details of the user by id.
	User getByid(int id);

	List<User> findAll();

}
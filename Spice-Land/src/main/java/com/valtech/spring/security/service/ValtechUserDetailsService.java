package com.valtech.spring.security.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Service;

import com.valtech.spring.security.entity.Products;
import com.valtech.spring.security.entity.User;
import com.valtech.spring.security.repo.UserReopsitory;

@Service
public class ValtechUserDetailsService {

	@Autowired
	private UserReopsitory userRepository;

	// To delete details of all users.
	public void resetUser() {
		userRepository.deleteAll();

	}

	// Create the new user.
	public void createUser(User user) {
		userRepository.save(user);
	}

	// To find whether user of that username is already register or not.
	public int LoginValidator(String username) {

		if (userRepository.findByUsername(username) != null) {
			return 1;
		}

		return 0;

	}

	// To get the roles of the user(admin,user,delivery person).
	public String getrole(String username) {

		User u = userRepository.findByUsername(username);

		return u.getRole();
	}

	// To get the id of that username.
	public int getId(String username) {

		User u = userRepository.findByUsername(username);

		return u.getId();
	}

	// To get username by the id.
	public User getUsername(int id) {
		return userRepository.findUsernameById(id);

	}

	// Find whether user of that username is already register or not.
	public String findUser(String username) {

		if (userRepository.findByUsername(username) != null) {

			return userRepository.findByUsername(username).getUsername();
		}

		return "false";

	}

	// To get the details of the user by username.
	public User findentierUser(String username) {
		return userRepository.findUserByUsername(username);
	}

	// Find password of the user by username.
	public String findUserPass(String username) {

		if (userRepository.findByUsername(username) != null) {

			return userRepository.findByUsername(username).getPass();
		}

		return "false";

	}

	// Details of the user by id.
	public User getuser(int id) {

		return userRepository.findById(id);
	}

	// To update the details of the user.
	public User updateUser(User user) {
		return userRepository.save(user);
	}

	// List of the user by role.
	public List<User> getAlluser() {
		return userRepository.findByRole("ADMIN");
	}

	// Details of the user by id.
	public User getByid(int id) {
		return userRepository.findById(id);
	}
	
	public List<User> findAll() {
		
		return userRepository.findAll();
		
	}

}

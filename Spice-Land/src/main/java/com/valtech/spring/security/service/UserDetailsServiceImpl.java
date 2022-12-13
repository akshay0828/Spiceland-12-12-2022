package com.valtech.spring.security.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Service;

import com.valtech.spring.security.entity.Products;
import com.valtech.spring.security.entity.User;
import com.valtech.spring.security.repo.UserReopsitory;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserReopsitory userRepository;
	
	private static final Logger logger = LoggerFactory.getLogger(UserDetailsServiceImpl.class);

	// To delete details of all users.
	@Override
	public void resetUser() {
		userRepository.deleteAll();

	}

	// Create the new user.
	@Override
	public void createUser(User user) {
		logger.info("Saving New User");
		userRepository.save(user);
		
	}

	// To find whether user of that username is already register or not.
	@Override
	public int LoginValidator(String username) {
        logger.info("");
		if (userRepository.findByUsername(username) != null) {
			return 1;
		}

		return 0;

	}
	

	// To get the roles of the user(admin,user,delivery person).
	@Override
	public String getrole(String username) {

		User u = userRepository.findByUsername(username);

		return u.getRole();
	}
	
	
	
	
	
	public String getrolebymail(String email) {

		User e = userRepository.findByEmail(email);

		return e.getRole();
	}
	
	
	
	
	

	// To get the id of that username.
	@Override
	public int getId(String username) {

		User u = userRepository.findByUsername(username);

		return u.getId();
	}

	// To get username by the id.
	@Override
	public User getUsername(int id) {
		return userRepository.findUsernameById(id);

	}

	// Find whether user of that username is already register or not.
	@Override
	public String findUser(String username) {

		if (userRepository.findByUsername(username) != null) {

			return userRepository.findByUsername(username).getUsername();
		}

		return "false";

	}

	// To get the details of the user by username.
	@Override
	public User findentierUser(String username) {
		return userRepository.findUserByUsername(username);
	}

	// Find password of the user by username.
	@Override
	public String findUserPass(String username) {

		if (userRepository.findByUsername(username) != null) {

			return userRepository.findByUsername(username).getPass();
		}

		return "false";

	}

	// Details of the user by id.
	@Override
	public User getuser(int id) {

		return userRepository.findById(id);
	}

	// To update the details of the user.
	@Override
	public User updateUser(User user) {
		logger.info("Updating User with id"+user.getId());
		User u= userRepository.save(user);
		logger.debug("User updated with id="+user.getId());
		return u;
	}

	// List of the user by role.
	@Override
	public List<User> getAlluser() {
		return userRepository.findByRole("ADMIN");
	}

	// Details of the user by id.
	@Override
	public User getByid(int id) {
		logger.info("Fetching user with id"+id);
		User u = userRepository.findById(id);
		logger.debug("User with id="+id+"is"+u);
		return u;
	}
	
	@Override
	public List<User> findAll() {
		logger.info("Loading all the user");
		List<User> users = userRepository.findAll();
		logger.info("Loaded"+users.size()+"Users");
		logger.debug("Users are "+users);
		return users;
		
	}

}

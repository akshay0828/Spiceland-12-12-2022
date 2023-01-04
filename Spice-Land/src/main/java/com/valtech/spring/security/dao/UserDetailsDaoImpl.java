package com.valtech.spring.security.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class UserDetailsDaoImpl implements UserDetailsDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private static final Logger logger = LoggerFactory.getLogger(UserDetailsDaoImpl.class);
	
	@Override
	public void forgotPasswordDao(String username, String password) throws Exception {

		logger.info("Updating password with JDBC Query");
		String sql = "update users set pass = ? where username = ?";

		jdbcTemplate.update(sql, password, username);

	}
	
	@Override
	public void updateUserDao(String name, String email, String contact, String street, String area, String city,
			String pincode, int id) {
		logger.info("Updating User with id" + id);
		String sql = "update users set name = ? ,email= ?, contact=?, street= ?, area= ?, city=?, pincode=? where id = ?";

		jdbcTemplate.update(sql, name, email, contact, street, area, city, pincode, id);
		logger.debug("User updated with id=" + id);

	}
	
	
	

}

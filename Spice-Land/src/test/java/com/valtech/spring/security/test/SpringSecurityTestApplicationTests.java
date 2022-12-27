package com.valtech.spring.security.test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithAnonymousUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.valtech.spring.security.entity.User;
import com.valtech.spring.security.service.UserDetailsService;

@SpringBootTest


@AutoConfigureMockMvc
class SpringSecurityTestApplicationTests {

	@Autowired
	private MockMvc mvc;

	private UserDetailsService service;

	@Test
	@WithAnonymousUser
	public void testIndex() throws Exception {
		this.mvc.perform(MockMvcRequestBuilders.get("/index")).andExpect(MockMvcResultMatchers.status().isOk());
	}

	@Test
	@WithAnonymousUser
	public void testLogin() throws Exception {
		mvc.perform(get("/login")).andExpect(status().isOk());
	}

	@Test
	@WithAnonymousUser
	public void textRegister() throws Exception {
		mvc.perform(get("/register")).andExpect(status().isOk());
	}

	@Test
	public void loginAdmin() throws Exception {
		mvc.perform(get("/login")).andExpect(status().isOk());
	}

	@Test
	public void testAdminHome() {
		int id = 1;
		try {
			List<User> users = service.findAll();
			ArrayList<Integer> userIds = new ArrayList<>();

			if (users.size() > 0) {

				for (User user : users) {
					System.out.println("USER_ID CHECKED");

					userIds.add(user.getId());

				}

				System.out.println("Id." + userIds.get(0));

				for (int i = 0; i < userIds.size(); i++) {

					mvc.perform(get("/admin/adminhome/{id}", userIds.get(i))).andExpect(status().isOk());
				}

			}

		} catch (Exception e) {

		}
	}

	@Test
	public void testUserHome() {
		int id = 1;
		try {
			List<User> users = service.findAll();
			ArrayList<Integer> userIds = new ArrayList<>();

			if (users.size() > 0) {

				for (User user : users) {
					System.out.println("USER_ID CHECKED");

					userIds.add(user.getId());

				}

				System.out.println("Id." + userIds.get(0));

				for (int i = 0; i < userIds.size(); i++) {

					mvc.perform(get("/user/userhome/{id}", userIds.get(i))).andExpect(status().isOk());
				}

			}

		} catch (Exception e) {

		}
	}

	@Test
	public void testDeliveryHome() {
		int id = 1;
		try {
			List<User> users = service.findAll();
			ArrayList<Integer> userIds = new ArrayList<>();

			if (users.size() > 0) {

				for (User user : users) {
					System.out.println("USER_ID CHECKED");

					userIds.add(user.getId());

				}

				System.out.println("Id." + userIds.get(0));

				for (int i = 0; i < userIds.size(); i++) {

					mvc.perform(get("/delivery/deliverhome/{id}", userIds.get(i))).andExpect(status().isOk());
				}

			}

		} catch (Exception e) {

		}
	}

}

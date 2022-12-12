/*package com.valtech.spring.security.test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithAnonymousUser;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@EnableAutoConfiguration(exclude=SecurityAutoConfiguration.class)
@AutoConfigureMockMvc
class SpringSecurityTestApplicationTests {


		@Autowired
		private MockMvc mvc;
		
		
	@Test
	@WithAnonymousUser
	void testHelloWithAnanomus() throws Exception {
		mvc.perform(get("/register")).andDo(print()).andExpect(content().string("register")).andExpect(status().isOk());
	}

	@Test
	@WithAnonymousUser
	void testUerWithAnanomusShoundRetuenUnauthorized() throws Exception {
		mvc.perform(get("/user")).andDo(print()).andExpect(status().isUnauthorized());
		
	}

	
	@Test
	@WithMockUser(roles="USER")
	void testUserPageWithUser() throws Exception {
		mvc.perform(get("/user")).andDo(print()).andExpect(content().string("Hello User")).andExpect(status().isOk());
		
	}
	
	@Test
	@WithMockUser(roles="USER")
	void testDeliveryPersonPageWithUser() throws Exception {
		mvc.perform(get("/deliveryPerson")).andDo(print()).andExpect(content().string("Hello DeliveryPerson")).andExpect(status().isOk());
		
	}
	
	@Test
	@WithMockUser(roles="USER")
	void testAdminPageWithUserShouldReturnUnauthorized() throws Exception {
		mvc.perform(get("/seller")).andDo(print()).andExpect(status().isOk());
	}

	@Test
	@WithMockUser(roles="ADMIN")
	void testAdminPageWithAdmin() throws Exception {
		mvc.perform(get("/seller")).andDo(print()).andExpect(content().string("Hello seller")).andExpect(status().isOk());
	}
	
}
*/
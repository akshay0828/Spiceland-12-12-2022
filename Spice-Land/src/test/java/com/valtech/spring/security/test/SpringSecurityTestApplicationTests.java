package com.valtech.spring.security.test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithAnonymousUser;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import com.valtech.spring.security.entity.User;
import com.valtech.spring.security.service.ValtechUserDetailsService;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@EnableAutoConfiguration(exclude=SecurityAutoConfiguration.class)
@AutoConfigureMockMvc
class SpringSecurityTestApplicationTests {


		@Autowired
		private MockMvc mvc;
		
		@Autowired
		private ValtechUserDetailsService service;
		
	
		
		@Test
	    @WithAnonymousUser
	    void testIndex() throws Exception {
	        mvc.perform(get("/index")).andExpect(status().isOk());
	    }



	   
	    @Test
	    @WithAnonymousUser
	    void testLogin() throws Exception {
	        mvc.perform(get("/login")).andExpect(status().isOk());
	    }
	    
	    @Test
	    @WithAnonymousUser
	    void textRegister() throws Exception {
	        mvc.perform(get("/register")).andExpect(status().isOk());
	    }
	    
	     @Test
	     void testAdminHome() throws Exception {
	       //  int id = 1;
	         List<User> users= service.findAll();
	         ArrayList<Integer> userIds = new ArrayList<>();
	         
	         if(users.size()>0){
	             
	             for (User user : users) {
	                 System.out.println("USER_ID CHECKED");
	                 
	                 userIds.add(user.getId());
	             
	             }
	             
	             System.out.println("Id."+userIds.get(0));
	            
	             for (int i = 0; i < userIds.size(); i++) {
	            	 
	            	 mvc.perform(get("/admin/adminhome/{id}",userIds.get(i))).andExpect(status().isOk());
				}
	             
	        
	         
	         
	     }
	     }
		
		
		
		
		
		
		
		
		
	
}

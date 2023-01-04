package com.valtech.spring.security;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class SpringSecurityTestApplication extends SpringBootServletInitializer  {

	
	@Override  
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application)   
	{ 
		
		
	return application.sources(SpringSecurityTestApplication.class);  
	}
	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityTestApplication.class, args);
	}

}

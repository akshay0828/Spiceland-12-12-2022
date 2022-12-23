package com.valtech.spring.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import com.valtech.spring.security.service.UserDetailsServiceImpl;

@EnableWebSecurity
@EnableGlobalMethodSecurity(jsr250Enabled = true, securedEnabled = true, prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Bean
	public UserDetailsService userDetailsService() {
		return new UserDetailsServiceImpl();
	}
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		return bCryptPasswordEncoder;
	}
	
	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
		authProvider.setUserDetailsService(userDetailsService());
		authProvider.setPasswordEncoder(passwordEncoder());
		
		return authProvider;
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(authenticationProvider());
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.csrf().disable();
        http.headers().frameOptions().disable();
		http.authorizeRequests()
		.antMatchers("/user/**").hasAnyAuthority("USER")
		//.antMatchers("/user/**").hasRole("USER")
		.antMatchers("/admin/**").hasAnyAuthority("ADMIN")
		//.antMatchers("/admin/**").hasRole("ADMIN")
		.antMatchers("/delivery/**").hasAnyAuthority("DELIVERY")
		//.antMatchers("/delivery/**").hasRole("DELIVERY")
		.antMatchers("/register", "/login", "/logout","/index","/forgotpassword","/changepassword/**").permitAll()
		.anyRequest().authenticated()
		
		.and()
		.formLogin().loginProcessingUrl("/login") 
		.loginPage("/login")
		.successForwardUrl("/login").failureForwardUrl("/login")
		 .usernameParameter("username")//
         .passwordParameter("pass").permitAll()
		.and()
		.logout().permitAll()
		.and()
		.exceptionHandling().accessDeniedPage("/403")
		;
	}
	
	@Override
	public void configure(WebSecurity web) throws Exception {
	    web.ignoring().antMatchers("/css/**");
	    web.ignoring().antMatchers("/images/**");
	    web.ignoring().antMatchers("/js/**");
	}
	/*@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.headers().frameOptions().disable();

		http.authorizeRequests()
		
			 .antMatchers("/user/**").hasRole("USER")
			.antMatchers("/admin","/admin/**").hasRole("ADMIN")
			.antMatchers("/delivery/**").hasRole("USER")
			.antMatchers("/register", "/login", "/logout").permitAll()
			.and()
			
		      .formLogin()
		      .loginPage("/login")// (5)
		        .defaultSuccessUrl("/index") // (5)
		        .failureUrl("/login")
		        .permitAll()
		        .and()
		        
		        .httpBasic();
		     http.logout() // (6)
		       .permitAll()
		       .and();
		//     .httpBasic(); // (7)
		        return http.build();
	

	
	}*/
	
	


	

}

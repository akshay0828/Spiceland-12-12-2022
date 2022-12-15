package com.valtech.spring.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.FormLoginConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@EnableGlobalMethodSecurity(jsr250Enabled = true, securedEnabled = true, prePostEnabled = true)
public class WebSecurityConfig {

	@Bean
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
		      /*.loginPage("/login")// (5)
*/		        .defaultSuccessUrl("/index") // (5)
		        .failureUrl("/login")
		        .permitAll()
		        .and()
		        
		        .httpBasic();
		     http.logout() // (6)
		       .permitAll()
		       .and();
		//     .httpBasic(); // (7)
		        return http.build();
	

	
	}
	
	

//	@Bean
//	public PasswordEncoder passwordEncoder() {
//		return new BCryptPasswordEncoder();
//	}

	@Bean
	public UserDetailsManager userDetailsManager(PasswordEncoder passwordEncoder) {

		InMemoryUserDetailsManager udm = new InMemoryUserDetailsManager();

		udm.createUser(User.withUsername("scott").password(passwordEncoder.encode("tiger")).roles("USER").build());
		udm.createUser(
				User.withUsername("admin").password(passwordEncoder.encode("admin1")).roles("USER", "ADMIN","DELIVERY").build());
		return udm;

	}

}

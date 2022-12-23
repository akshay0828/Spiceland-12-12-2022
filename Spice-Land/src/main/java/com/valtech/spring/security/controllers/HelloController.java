package com.valtech.spring.security.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.valtech.spring.security.config.WebSecurityConfig;
import com.valtech.spring.security.entity.MyUserDetails;
import com.valtech.spring.security.entity.Role;
import com.valtech.spring.security.entity.User;
import com.valtech.spring.security.model.RegisterUserModel;
import com.valtech.spring.security.repo.Rolerepo;
import com.valtech.spring.security.service.UserDetailsService;

@Controller
public class HelloController {

	@Autowired
	private UserDetailsService service;

	int uid;
	
	@Autowired
	private WebSecurityConfig webSecurityConfig;

	@Autowired
	private Rolerepo roleRepo;

	/*
	 * If the seller/admin is new user Navigate to the registration page .
	 */
	@GetMapping("/register")
	public String register(Model model) {
		
		
		model.addAttribute("roleval", roleRepo.findAll());
		
		return "/register";
	}

	/*
	 * Seller/Admin should enter the details
	 * (name,username,email,password,confirmpassword,contact,address). username
	 * should not be repititive if so it displays error message. password and
	 * confirmpassword should be same else error message is displayed.
	 */

	@PostMapping("/register")
	public String registerUser(@ModelAttribute User user, @RequestParam("username") String username,
			@RequestParam("role") String role, @RequestParam("pass") String pass, Model model,
			@RequestParam("cnfmpass") String cnfmpass) {

		// user.setRole(user.getRole());
		String u;
		u = service.findUser(username);
		if (u == "false") {

			if (user.getPass().equals(user.getCnfmpass())) {
				user.setPass(webSecurityConfig.passwordEncoder().encode(pass));
				//Ruser.setCnfmpass(webSecurityConfig.passwordEncoder().encode(cnfmpass));
				
				 Role role1 = roleRepo.findByName(role);
			       
			        
			        Set<Role> roles= new HashSet<Role>();
			        
			        roles.add(role1);
			        
			        user.setRoles(roles);
				
				
				user.setEnabled(true);

				service.createUser(user);
				MyUserDetails use =new MyUserDetails(user);
				
				return "redirect:/login";
			} else {
				model.addAttribute("error", "Password and Confirm Password does not match");

				return "register";
			}

		}
		model.addAttribute("userna", "Username Already Exists");
		return "register";
	}

	@GetMapping("/login")
	public String login() {
		return "login";
	}

	@GetMapping("register/login")
	public String login1() {
		return "login";
	}

	/*
	 * Seller/Admin should provide the username and password . If username and
	 * password of the registered seller matches it will navigate to
	 * seller/admin dashboard else it will display the error message.
	 */
	@PostMapping("/login")

	public String loginUser(@ModelAttribute RegisterUserModel registerUserModel, Model model,
			@RequestParam(value = "error", defaultValue = "true") boolean loginError) throws Exception {
		String url;
		String s1 = "ADMIN";
		String s2 = "USER";
		String s3 = "DELIVERY";
		System.out.println(""+service.loadUserByUsername(registerUserModel.getUsername()));

		try {

			String role = service.getrole(registerUserModel.getUsername());

			if (role.equals(s1)) {
				if (webSecurityConfig.passwordEncoder().matches((registerUserModel.getPass()),
						service.findUserPass(registerUserModel.getUsername()))
						&& registerUserModel.getUsername().equals(service.findUser(registerUserModel.getUsername()))) {

					System.out.println(
							registerUserModel.getUsername() + service.findUser(registerUserModel.getUsername()));
					System.out.println("PASSWORD");
					System.out.println(registerUserModel.getPass() + service.findUser(registerUserModel.getPass()));

					System.out.println("SUCCESS");
					int id = service.getId(registerUserModel.getUsername());

					uid = id;

					return url = "redirect:/admin/adminhome/" + id;

				}

				else {
					String message = "Invalid Username and Password";
					System.out.println(message);
					model.addAttribute("mess", message);
					return "login";

				}

			} else if (role.equals(s2)) {

				if (webSecurityConfig.passwordEncoder().matches((registerUserModel.getPass()),
						service.findUserPass(registerUserModel.getUsername()))
						&& registerUserModel.getUsername().equals(service.findUser(registerUserModel.getUsername()))) {

					System.out.println(
							registerUserModel.getUsername() + service.findUser(registerUserModel.getUsername()));

					System.out.println("SUCCESS");
					int id = service.getId(registerUserModel.getUsername());

					return url = "redirect:/user/userhome/" + id;

				}

				else {
					String message = "Invalid Username and Password";
					System.out.println(message);
					model.addAttribute("mess", message);
					return "login";

				}

			}

			else if (role.equals(s3)) {

				if (webSecurityConfig.passwordEncoder().matches((registerUserModel.getPass()),
						service.findUserPass(registerUserModel.getUsername()))
						&& registerUserModel.getUsername().equals(service.findUser(registerUserModel.getUsername()))) {

					System.out.println(
							registerUserModel.getUsername() + service.findUser(registerUserModel.getUsername()));

					System.out.println("SUCCESS");
					int id = service.getId(registerUserModel.getUsername());

					return url = "redirect:/delivery/deliverhome/" + id;

				}

				else {
					String message = "Invalid Username and Password";
					System.out.println(message);
					model.addAttribute("mess", message);
					return "login";

				}

			}

		} catch (Exception n) {
			String message = "Invalid Username and Password";
			System.out.println(message);
			model.addAttribute("mess", message);
			return "login";
		}
		return "login";

	}
	
	
	/*
	 * If seller/admin forgets password,will have an option to change the
	 * password
	 * 
	 */

	@GetMapping("/forgotpassword")
	public String adminForgotPassword() {
		return "forgotpassword";
	}

	/*
	 * Seller/Admin should enter the username If the username exists it wil
	 * navigate to changepassword page else it will display the error message
	 */
	@PostMapping("/forgotpassword")

	public String adminpostForgotPassword(@ModelAttribute User user, @RequestParam("username") String username,
			Model model) {

		String u;
		u = service.findUser(username);

		if (u == "false") {
			model.addAttribute("error", "User Does Not Exists");
			return "forgotpassword";
		} else {

			model.addAttribute("add", username);
			return "redirect:/changepassword/" + username;
		}
	}

	/*
	 * If the username entered in the forgot password page, it will navigate to
	 * changepassword page.
	 */

	@GetMapping("/changepassword/{username}")
	public String adminchangePassword(@PathVariable("username") String username, Model model) {
		model.addAttribute("userna", username);

		return "changepassword";
	}
	/*
	 * Seller/admin can enter the new password If the password and confirm
	 * password doesn't match it will again ask to enter the username and then
	 * can change the password,password will change successfully.
	 */

	@PostMapping("/changepassword/{username}")
	public String adminupdatechangePassword(@PathVariable("username") String username,
			@RequestParam("pass") String password, @RequestParam("cnfmpass") String confirmPassword, Model model) {
		if (password.equals(confirmPassword)) {
			User u;
			u = service.findentierUser(username);
			u.setPass(webSecurityConfig.passwordEncoder().encode(password));
			u.setCnfmpass(webSecurityConfig.passwordEncoder().encode(confirmPassword));
			service.updateUser(u);
			System.out.println(u.getPass());
			return "redirect:/login";

		} else {
			model.addAttribute("me", "Password And ConfirmPassword Does Not match");
			model.addAttribute("mes", "Re-Enter the Username");
			return "forgotpassword";

		}

	}

	@GetMapping("/index")
	public String index() {
		return "Index";
	}

	@GetMapping("/customer")
	public String pay() {
		return "customer";
	}

}

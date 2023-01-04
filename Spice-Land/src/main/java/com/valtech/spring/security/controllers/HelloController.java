package com.valtech.spring.security.controllers;

import java.util.HashSet;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.valtech.spring.security.config.WebSecurityConfig;
import com.valtech.spring.security.dao.UserDetailsDao;
import com.valtech.spring.security.entity.MyUserDetails;
import com.valtech.spring.security.entity.Role;
import com.valtech.spring.security.entity.User;
import com.valtech.spring.security.model.RegisterUserModel;
import com.valtech.spring.security.repo.Rolerepo;
import com.valtech.spring.security.service.RoleService;
import com.valtech.spring.security.service.UserDetailsService;

@Controller
public class HelloController {

	@Autowired
	private UserDetailsService service;

	int uid;

	@Autowired
	private WebSecurityConfig webSecurityConfig;

	@Autowired
	private RoleService roleService;
	
	

	private static final Logger logger = LoggerFactory.getLogger(HelloController.class);

	/*
	 * If the seller/admin is new user Navigate to the registration page .
	 */
	@GetMapping("/register")
	public String register(Model model) throws Exception {
		logger.info("Navigating towards registration page");
		model.addAttribute("roleval", roleService.findAll());
		return "/register";
	}

	/*
	 * Seller/Admin should enter the details
	 * (name,username,email,password,confirmpassword,contact,address). username
	 * should not be repititive if so it displays error message. password and
	 * confirmpassword should be same else error message is displayed.
	 */

	@PostMapping("/register")
	public String registerUser(@ModelAttribute RegisterUserModel registerUserModel,
			@RequestParam("username") String username, @RequestParam("role") String role,
			@RequestParam("pass") String pass, Model model, @RequestParam("cnfmpass") String cnfmpass) {
		model.addAttribute("roleval", roleService.findAll());

		String u = service.findUser(username);

		if (u == "false") {
			logger.debug("Existence in database is false for " + u);
			if (registerUserModel.getPass().equals(registerUserModel.getCnfmpass())) {
				User user = new User(registerUserModel.getName(), registerUserModel.getEmail(),
						registerUserModel.getUsername(),
						webSecurityConfig.passwordEncoder().encode(registerUserModel.getPass()),
						registerUserModel.getStreet(), registerUserModel.getArea(), registerUserModel.getCity(),
						registerUserModel.getPincode(), registerUserModel.getContact(), registerUserModel.getRole());

				Role role1 = roleService.getbyName(role);
				
				Set<Role> roles = new HashSet<Role>();
				roles.add(role1);
				
				user.setRoles(roles);
				logger.debug("Creating the user with details " + user);
				service.createUser(user);
				MyUserDetails use = new MyUserDetails(user);
				return "redirect:/login";

			} else {
				logger.error("The passwords that is " + pass + " and " + cnfmpass + " doesn't match.");
				model.addAttribute("error", "Password and Confirm Password does not match");
				return "/register";
			}
		}
		model.addAttribute("error", "Username Already Exists");
		return "/register";
	}

	@GetMapping("/login")
	public String login(Model model) {
		logger.info("Navigation towards login page");
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

		try {
			String role = service.getrole(registerUserModel.getUsername());
			logger.debug("Logging with the role as " + role);
			if (role.equals(s1)) {

				if (webSecurityConfig.passwordEncoder().matches((registerUserModel.getPass()),
						service.findUserPass(registerUserModel.getUsername()))
						&& registerUserModel.getUsername().equals(service.findUser(registerUserModel.getUsername()))) {

					logger.debug(registerUserModel.getUsername() + service.findUser(registerUserModel.getUsername()));

					int id = service.getId(registerUserModel.getUsername());

					uid = id;

					logger.debug(registerUserModel.getUsername() + "has successfully logged-in as " + role);
					return url = "redirect:/admin/adminhome/" + id;

				}

				else {

					model.addAttribute("error", "Invalid Username and Password");
					return "/login";

				}

			} else if (role.equals(s2)) {

				if (webSecurityConfig.passwordEncoder().matches((registerUserModel.getPass()),
						service.findUserPass(registerUserModel.getUsername()))
						&& registerUserModel.getUsername().equals(service.findUser(registerUserModel.getUsername()))) {

					logger.debug(registerUserModel.getUsername() + service.findUser(registerUserModel.getUsername()));

					logger.debug("Successful");

					int id = service.getId(registerUserModel.getUsername());
					logger.debug(registerUserModel.getUsername() + "has successfully logged-in as " + role);
					return url = "redirect:/user/userhome/" + id;

				}

				else {
					model.addAttribute("error", "Invalid Username and Password");
					return "/login";

				}

			}

			else if (role.equals(s3)) {

				if (webSecurityConfig.passwordEncoder().matches((registerUserModel.getPass()),
						service.findUserPass(registerUserModel.getUsername()))
						&& registerUserModel.getUsername().equals(service.findUser(registerUserModel.getUsername()))) {

					logger.debug(registerUserModel.getUsername() + service.findUser(registerUserModel.getUsername()));

					int id = service.getId(registerUserModel.getUsername());
					logger.debug(registerUserModel.getUsername() + "has successfully logged-in as " + role);
					return url = "redirect:/delivery/deliverhome/" + id;

				}

				else {
					model.addAttribute("error", "Invalid Username and Password");
					return "/login";

				}

			}

		} catch (Exception n) {
			logger.error("Invalid credentials");
			model.addAttribute("error", "Invalid Username and Password");
			return "/login";
		}
		return "/login";

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
			@RequestParam("pass") String password, @RequestParam("cnfmpass") String confirmPassword, Model model)
			throws Exception {
		if (password.equals(confirmPassword)) {

			service.forgotPassword(username, webSecurityConfig.passwordEncoder().encode(password));
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

}

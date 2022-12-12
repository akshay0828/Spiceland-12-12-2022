package com.valtech.spring.security.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.valtech.spring.security.entity.User;
import com.valtech.spring.security.model.RegisterUserModel;
import com.valtech.spring.security.repo.CartLineRepo;
import com.valtech.spring.security.repo.UserReopsitory;
import com.valtech.spring.security.service.CartLineService;
import com.valtech.spring.security.service.OrderService;
import com.valtech.spring.security.service.ProductServiceImpl;
import com.valtech.spring.security.service.UserDetailsService;

@Controller
public class DeliveryController {
	@Autowired
	private UserReopsitory userRepository;

	@Autowired
	private UserDetailsService service;


	int uid;

	

	@Autowired
	private OrderService orderService;

	

	/*
	 * Once the delivery person login, It will navigate to the deliverhome.
	 */
	@GetMapping("/delivery/deliverhome/{id}")
	public String deliveryhome(@PathVariable("id") int id, ModelMap model) {
		model.addAttribute("user", service.getuser(id));

		return "delivery/deliverhome";
	}

	/*
	 * If delivery person wants to update the profile Navigate to updateprofile
	 * page.
	 */
	@GetMapping("/delivery/updateprofile/{id}")
	public String deliveryUpdate(@PathVariable("id") int id, Model model) {
		model.addAttribute("user", service.getuser(id));
		return "/delivery/updateprofile";
	}

	/*
	 * Delivery person can Update the profile.
	 */
	@PostMapping("/delivery/updateProfile/{id}")
	public String deliveryUpdateInsert(@PathVariable("id") int id, @ModelAttribute User user, Model model) {
		System.out.println("SUCCESS");
		model.addAttribute("user", service.getuser(id));
		service.updateUser(user);

		return "redirect:/delivery/deliverhome/{id}";
	}

	/*
	 * Delivery person can view the orders place by buyer/user.
	 */

	@GetMapping("/delivery/getOrders/{id}")
	public String getOrders(@PathVariable("id") int id, Model model) {
		model.addAttribute("user", service.getByid(id));
		model.addAttribute("Orders", orderService.findAll());

		return "delivery/getOrders";
	}
	/*
	 * Delivery person can accept the order.
	 */

	@PostMapping("/delivery/getOrders/{userid}/{orderid}/{customerid}")
	public String DeleteProduct(Model model, @PathVariable("userid") int userid, @PathVariable("orderid") int id,
			@PathVariable("customerid") int customerid) {

		orderService.deletebyId(id);

		return "redirect:/delivery/acceptorder/" + userid + "/" + customerid;

	}

	/*
	 * Once delivery person accept the order the details of the buyer/user will
	 * displayed .
	 */

	@GetMapping("/delivery/acceptorder/{id}/{userid}")
	public String acceptorders(@PathVariable("id") int id, Model model, @PathVariable("userid") int userid) {
		model.addAttribute("deliver", service.getByid(id));
		model.addAttribute("user", service.getByid(userid));

		return "delivery/acceptorder";
	}

}

package com.valtech.spring.security.controllers;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.twilio.Twilio;
import com.twilio.exception.AuthenticationException;
import com.twilio.rest.api.v2010.account.Message;
import com.valtech.spring.security.dao.UserDetailsDao;
import com.valtech.spring.security.entity.Orders;
import com.valtech.spring.security.entity.User;
import com.valtech.spring.security.repo.Rolerepo;
import com.valtech.spring.security.service.OrderService;
import com.valtech.spring.security.service.UserDetailsService;

@Controller
public class DeliveryController {

	@Autowired
	private UserDetailsService service;

	
	int uid;

	@Autowired
	private OrderService orderService;

	public static final String ACCOUNT_SID = "ACe165455b3f498dd288a7ffa8aa7a3d5c";
	public static final String AUTH_TOKEN = "1b67419c0a54b7981f467653d2c217e0";

	private static final Logger logger = LoggerFactory.getLogger(DeliveryController.class);

	/*
	 * Once the delivery person login, It will navigate to the deliverhome.
	 */
	@GetMapping("/delivery/deliverhome/{id}")
	public String deliveryhome(@PathVariable("id") int id, ModelMap model) {
		logger.info("Navigating towards delivery dashboard");
		model.addAttribute("user", service.getuser(id));
		List<Orders> orders = orderService.findAll();
		ArrayList<Integer> customerIds = new ArrayList<>();

		if (orders.size() > 0) {
			logger.debug("The number of orders received is " + orders.size());

			for (Orders order : orders) {

				if (customerIds.contains(order.getUser_id())) {
					logger.info("No Entry of duplicate location available in drop-down ");
				} else {
					customerIds.add(order.getUser_id());
					logger.info("Entry of new location into the drop-down");
				}
			}
		}

		ArrayList<String> address = new ArrayList<>();

		for (int i = 0; i < customerIds.size(); i++) {

			User user = service.getByid(customerIds.get(i));

			address.add(user.getArea());

		}

		model.addAttribute("address", address);

		logger.debug("Currently available orders based on location is/are " + address);

		return "delivery/deliverhome";
	}

	/*
	 * If delivery person wants to update the profile Navigate to updateprofile
	 * page.
	 */
	@GetMapping("/delivery/updateprofile/{id}")
	public String deliveryUpdate(@PathVariable("id") int id, Model model) {
		logger.info("Navigating towards profile updation page");
		model.addAttribute("user", service.getuser(id));

		return "/delivery/updateprofile";
	}

	/*
	 * Delivery person can Update the profile.
	 */
	@PostMapping("/delivery/updateProfile/{id}")
	public String deliveryUpdateInsert(@PathVariable("id") int id, @ModelAttribute User user, Model model) {
		logger.info("Updating the profile details of the delivery-person  " + user.getName());
		model.addAttribute("user", service.getuser(id));

		service.updateUser(user.getName(), user.getEmail(), user.getContact(), user.getStreet(), user.getArea(),
				user.getCity(), user.getPincode(), id);
		logger.debug("Successful updation for the delivery-person " + user.getName());

		return "redirect:/delivery/deliverhome/{id}";
	}

	/*
	 * Delivery person can view the orders place by buyer/user.
	 */
	String location;

	@GetMapping("/delivery/getOrders/{id}")
	public String getOrders(@PathVariable("id") int id, @RequestParam("address") String loc, Model model) {
		model.addAttribute("user", service.getByid(id));
		location = loc;
		model.addAttribute("Orders", orderService.FindByArea(loc));
		logger.debug("Location " + loc);
		return "delivery/getOrders";
	}
	/*
	 * Delivery person can accept the order.
	 */

	@PostMapping("/delivery/getOrders/{userid}/{orderid}/{customerid}")
	public String DeleteProduct(Model model, @PathVariable("userid") int userid, @PathVariable("orderid") int id,
			@PathVariable("customerid") int customerid) throws AuthenticationException {

		try {

			User user = service.getByid(customerid);
			User delivery = service.getByid(userid);
			logger.debug("Contact" + user.getContact());
			logger.debug("LOCATION FROM POST...." + location);

			Orders order = orderService.getById(id);

			Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

			logger.info("Usage of Twilio for messaging service");

			Message message = Message.creator(new com.twilio.type.PhoneNumber("+91" + user.getContact()),
					new com.twilio.type.PhoneNumber("+16506403682"),
					"Your order has been accepted," + delivery.getName()
							+ " is your deliver partner, contact him to receive your order, on time "
							+ delivery.getContact())
					.create();
			/*
			 * Message message1 = Message.creator(new
			 * com.twilio.type.PhoneNumber("+919686083306"),new
			 * com.twilio.type.PhoneNumber("+16506403682"),"to akshay")
			 * .create();
			 */

			logger.debug("The message is sent from twilio account " + ACCOUNT_SID
					+ " confirming towards order been accepted by " + delivery.getName() + "to " + user.getContact());
			logger.trace("The trace containing the successful transfer of message " + message.getSid());

		}

		catch (Exception e) {

			logger.error("Message not sent successfully as resulting towards expiry of AUTH_TOKEN >>>>>" + AUTH_TOKEN);
			return "redirect:/delivery/acceptorder/" + userid + "/" + customerid;
		} finally {
			orderService.deletebyId(id);
		}
		return "redirect:/delivery/acceptorder/" + userid + "/" + customerid;
	}

	/*
	 * Once delivery person accept the order the details of the buyer/user will
	 * displayed .
	 */

	@GetMapping("/delivery/acceptorder/{id}/{userid}")
	public String acceptorders(@PathVariable("id") int id, Model model, @PathVariable("userid") int userid) {
		logger.info("Accepting orders placed by customer");
		model.addAttribute("deliver", service.getByid(id));
		model.addAttribute("user", service.getByid(userid));
		logger.debug("Accepted order with the " + id + " from the customer with the id " + userid);
		return "delivery/acceptorder";
	}

}

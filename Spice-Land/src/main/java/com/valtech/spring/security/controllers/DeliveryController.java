package com.valtech.spring.security.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.method.P;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.valtech.spring.security.entity.Orders;
import com.valtech.spring.security.entity.Products;
import com.valtech.spring.security.entity.User;
import com.valtech.spring.security.model.RegisterUserModel;
import com.valtech.spring.security.repo.CartLineRepo;
import com.valtech.spring.security.repo.UserReopsitory;
import com.valtech.spring.security.service.CartLineService;
import com.valtech.spring.security.service.OrderService;
import com.valtech.spring.security.service.ProductServiceImpl;
import com.valtech.spring.security.service.UserDetailsService;

import com.twilio.Twilio;
import com.twilio.exception.AuthenticationException;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;


@Controller
public class DeliveryController {
	@Autowired
	private UserReopsitory userRepository;

	@Autowired
	private UserDetailsService service;


	int uid;

	
	

	@Autowired
	private OrderService orderService;

	
	 public static final String ACCOUNT_SID = "ACe165455b3f498dd288a7ffa8aa7a3d5c"; 
	    public static final String AUTH_TOKEN = "7178b5e12675f77c74dc51d8718297b9"; 
	

	/*
	 * Once the delivery person login, It will navigate to the deliverhome.
	 */
	@GetMapping("/delivery/deliverhome/{id}")
	public String deliveryhome(@PathVariable("id") int id, ModelMap model) {
		model.addAttribute("user", service.getuser(id));
		
		List<Orders> orders=	orderService.findAll();
		ArrayList<Integer> customerIds = new ArrayList<>();
		
if(orders.size()>0){
			
			for (Orders order : orders) {
				if(customerIds.contains(order.getUser_id())){
				
				}
				else{
					customerIds.add(order.getUser_id());
				}
			}
}
			System.out.println(customerIds);
			
			 ArrayList<String> address=new ArrayList<>();
			
			for (int i = 0; i < customerIds.size(); i++) {
				
				User user=service.getByid(customerIds.get(i));
				
				System.out.println(user.getArea());
				
				address.add(user.getArea());
				
				
				
			}
			
			
			
			System.out.println(address);
			
			System.out.println(orderService.findAll());
			
			model.addAttribute("address",address);
		
			
			
			

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
String location;
	@GetMapping("/delivery/getOrders/{id}")
	public String getOrders(@PathVariable("id") int id,@RequestParam("address") String loc ,Model model) {
		model.addAttribute("user", service.getByid(id));
		location=loc;
		model.addAttribute("Orders", orderService.FindByArea(loc));
		System.out.println("LOCATION ......"+loc);
		return "delivery/getOrders";
	}
	/*
	 * Delivery person can accept the order.
	 */

	@PostMapping("/delivery/getOrders/{userid}/{orderid}/{customerid}")
	public String DeleteProduct(Model model, @PathVariable("userid") int userid, @PathVariable("orderid") int id,
			@PathVariable("customerid") int customerid) throws AuthenticationException{

		
		
		try{
			
			User user =service.getByid(customerid);
			User delivery =service.getByid(userid);
			System.out.println("Contact........ "+user.getContact());
			System.out.println("LOCATION FROM POST...."+location);
			
			Orders order=orderService.getById(id);
			
		System.out.println(order.getAdminIds());
			
			
			
			
			Twilio.init(ACCOUNT_SID, AUTH_TOKEN); 
	       
	        Message message = Message.creator(new com.twilio.type.PhoneNumber("+91"+user.getContact()),new com.twilio.type.PhoneNumber("+16506403682"),"hey your order has accepted,"+delivery.getName()+" is your deliver paterner, contact him to recive your order, on time"+delivery.getContact())
	            .create();
	      /*  Message message1 = Message.creator(new com.twilio.type.PhoneNumber("+919686083306"),new com.twilio.type.PhoneNumber("+16506403682"),"to akshay")
		            .create();*/
	        System.out.println("MESSAGE SENT");
	        System.out.println(message.getSid());
			
		//	orderService.deletebyId(id);
		
		}
		
		catch(Exception e){
			
			System.out.println("Message not send");
		return "redirect:/delivery/acceptorder/" + userid + "/" + customerid;
		}
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

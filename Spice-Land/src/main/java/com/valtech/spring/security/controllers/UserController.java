package com.valtech.spring.security.controllers;

import java.io.ByteArrayInputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.valtech.spring.security.dao.ProductDao;
import com.valtech.spring.security.dao.UserDetailsDao;
import com.valtech.spring.security.entity.CartLine;
import com.valtech.spring.security.entity.Orders;
import com.valtech.spring.security.entity.Products;
import com.valtech.spring.security.entity.User;
import com.valtech.spring.security.service.CartLineService;
import com.valtech.spring.security.service.OrderService;
import com.valtech.spring.security.service.ProductService;
import com.valtech.spring.security.service.UserDetailsService;
import com.valtech.spring.security.util.BillDownload;

@Controller
public class UserController {

	@Autowired
	private UserDetailsService service;

	@Autowired
	private ProductService productservice;
	
	

	int uid;

	@Autowired
	private CartLineService cartLineService;

	@Autowired
	private OrderService orderService;
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	@GetMapping("user/userhome/{id}")
	public String userhome(@PathVariable("id") final int id, final ModelMap model ,@RequestParam(value = "text", required = false) String search) {

		logger.info("Navigating towards the user-dashboard");

		final User u = service.getUsername(id);
		System.out.println(service.getUsername(id));
		model.addAttribute("add", u.getName());
		model.addAttribute("user", u.getId());
		
		if(search==null){

		model.addAttribute("Products", productservice.getAllProducts());
		}
		else if(productservice.searchForProduct(search).isEmpty()){
			model.addAttribute("error", "The Product you have searched is not in List");
		}
		else{
			model.addAttribute("Products", productservice.searchForProduct(search));
		}
		model.addAttribute("users", service.getAlluser());

		return "user/userhome";
	}
	/*
	 * If buyer/user wants to update the profile Navigate to updateprofile page.
	 */

	

	
	@GetMapping("/user/updateprofile/{id}")
	public String userUpdate(@PathVariable("id") final int id, final Model model) {
		logger.info("Navigation towards profile updation of the user with id " + id);
		model.addAttribute("user", service.getuser(id));
		return "/user/updateprofile";
	}
	/*
	 * Buyer/User can Update the profile.
	 */

	@PostMapping("/user/updateProfile/{id}")
	public String userUpdateInsert(@PathVariable("id") final int id, @ModelAttribute final User user, final Model model) {
		System.out.println("SUCCESS");
		model.addAttribute("user", service.getuser(id));

		service.updateUser(user.getName(), user.getEmail(), user.getContact(), user.getStreet(), user.getArea(),
				user.getCity(), user.getPincode(), id);
		logger.debug("Successfully updated the required profile details of the user " + service.getUsername(id));
		return "redirect:/user/userhome/{id}";
	}
	/*
	 * Buyer/User can add the required products to the cart.
	 */

	@GetMapping("user/userhome/{id}/{prod_id}")
	public String userhome1(@PathVariable("id") final int id, @PathVariable("prod_id") final int prod_id, final ModelMap model,
			final CartLine cartLine) throws Exception {

		try {
			logger.debug("Id of the specific-user trying to add products " + id);

			final User u = service.getUsername(id);
			System.out.println(service.getUsername(id));

			model.addAttribute("add", u.getName());
			model.addAttribute("user", u.getId());

			model.addAttribute("Products", productservice.getAllProducts());

			model.addAttribute("users", service.getAlluser());

			final Products p = productservice.getProduct(prod_id);

			final int check_User_id = cartLineService.findUserIdAndProdId_onlyUserId(id, prod_id);

			final int check_Prod_id = cartLineService.findUserIdAndProdId_onlyProdId(id, prod_id);

			final CartLine check = cartLineService.findUserIdAndProdId(id, prod_id);

			if (check_User_id == id & check_Prod_id == prod_id) {
				final User e = p.getUser();
				final CartLine c = new CartLine(prod_id, p.getProductName(), p.getPrice(), u.getId(), id);
				if (p.getQuantity() != 0) {
					check.setQuantity(check.getQuantity() + 1);
					p.setQuantity(p.getQuantity() - 1);
				} else {
					model.addAttribute("pempty", "Product is Out of Stock");
					System.out.println(p.getProductName());
				}
				final int a = p.getQuantity() - 1;
				logger.debug("Available quantity was " + p.getQuantity()
						+ " and after addition of item to cart the available quantity is " + a);
				cartLine.setProdid(prod_id);
				cartLineService.createCartLine(check);

			}

			model.addAttribute("cartLine", cartLineService.findAll());

		} catch (final DataIntegrityViolationException e)

		{
			final Products p = productservice.getProduct(prod_id);
			final CartLine cart = cartLineService.findByProId(prod_id);

			cartLine.setId(cart.getId());
			cartLine.setProdid(prod_id);
			cartLine.setProductName(p.getProductName());
			cartLine.setPrice(p.getPrice());
			cartLine.setQuantity(cart.getQuantity());
			logger.debug("The available quantity " + cartLine.getQuantity());

			cartLineService.createCartLine(cartLine);

		}

		catch (final NullPointerException n) {
			final Products p = productservice.getProduct(prod_id);

			final User u = p.getUser();
			final CartLine c = new CartLine(prod_id, p.getProductName(), p.getPrice(), u.getId(), id);
			cartLine.setAdminIds(u.getId());
			cartLine.setUserid(id);
			cartLine.setProdid(prod_id);
			c.setUserid(id);

			cartLineService.createCartLine(c);
		}

		return "user/userhome";
	}
	/*
	 * Buyer/User can view the cart items.
	 */

	@GetMapping("/user/cart/{id}")
	public String cart(final ModelMap model, @PathVariable("id") final int user_id) {
		model.addAttribute("user", service.getuser(user_id));
		if (cartLineService.getAllordersByuserid(user_id).size() == 0) {
			model.addAttribute("error", "Please add Items to cart");
		}
		model.addAttribute("cartLine", cartLineService.getAllordersByuserid(user_id));

		return "user/cart";
	}
	/*
	 * Buyer/User can delete the items added to the cart.
	 */

	@PostMapping("/user/cart/{id}/{userid}")

	public String DeleteCartLine(final Model model, @PathVariable("id") final int id, @PathVariable("userid") final int user_id) {

		System.out.println("DELETING");

		final CartLine c = cartLineService.findById(id);

		final Products p = productservice.getProduct(c.getProdid());

		p.setQuantity(p.getQuantity() + c.getQuantity() - 1);

		System.out.println();
		cartLineService.deleteCartLine(id);
		logger.debug("Successful deletion of cart item with id " + id + " of the user with id " + user_id);
		return "redirect:/user/cart/" + user_id;

	}
	/*
	 * If Buyer/User wish to place the order, it will navigate to payment page.
	 */

	@GetMapping("/user/payment/{id}")
	public String payment(final ModelMap model, @PathVariable("id") final int id) {
		logger.info("Navigating towards payment page");
		if (cartLineService.getAllordersByuserid(id).size() == 0) {
			model.addAttribute("error", "Please add Items to cart");
			return "redirect:/user/cart/" + id;
		}
		model.addAttribute("user", service.getuser(id));
		return "user/payment";
	}
	/*
	 * Buyer/User should enter the payment details .
	 */

	@PostMapping("/user/payment/{id}")

	public String SaveOrders(@PathVariable("id") final int id) {

		final ArrayList<Integer> cart_ids = cartLineService.findAllId(id);
		final ArrayList<Integer> admin_ids = cartLineService.findAllAdminId(id);

		final User user = service.getByid(id);

		final Orders o = new Orders();
		o.setUser_id(id);
		o.setCartIds(cart_ids);
		o.setDate(LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MMMM-yyyy / hh:mm")));

		o.setArea(user.getArea());

		o.setAdminIds(admin_ids);

		orderService.saveOrder(o);

		System.out.println("PAYMENT DONE ");

		return "redirect:/user/orderTracking/" + id;
	}
	/*
	 * Once the order placed, buyer/seller can track the order.
	 */

	@GetMapping("/user/orderTracking/{id}")
	public String order(final ModelMap model, @PathVariable("id") final int id) {

		model.addAttribute("user", service.getuser(id));

		model.addAttribute("cartLine", cartLineService.getAllordersByuserid(id));

		return "user/orderTracking";
	}
	/*
	 * Once the order is placed cart will be empty.
	 */

	@PostMapping("/user/orderTracking/{id}")
	public String feedback(final ModelMap model, @PathVariable("id") final int id) {

		cartLineService.EmptyCart(id);

		return "redirect:/user/feedback/" + id;
	}
	/*
	 * After order recieved buyer/user should provide feedback.
	 */

	@GetMapping("/user/feedback/{id}")
	public String feedbacksubmit(@PathVariable("id") final int id, final Model model) {
		logger.info("Navigating towards user feedback page");
		model.addAttribute("user", id);
		return "user/feedback";
	}

	@RequestMapping(value = "/user/pdfreport/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_PDF_VALUE)
	public ResponseEntity<InputStreamResource> cartBill(@PathVariable("id") final int id) {

		final List<CartLine> cartLines = cartLineService.getAllordersByuserid(id);

		final ByteArrayInputStream bis = BillDownload.cartBill(cartLines);

		final HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Disposition", "inline; filename=cartBill.pdf");

		return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_PDF)
				.body(new InputStreamResource(bis));
	}

}


package com.valtech.spring.security.controllers;

import java.io.IOException;
import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.valtech.spring.security.entity.Products;
import com.valtech.spring.security.entity.User;
import com.valtech.spring.security.repo.CartLineRepo;
import com.valtech.spring.security.repo.UserReopsitory;
import com.valtech.spring.security.service.CartLineService;
import com.valtech.spring.security.service.ProductServiceImpl;
import com.valtech.spring.security.service.UserDetailsService;

@Controller
public class AdminController {

	@Autowired
	private UserReopsitory userRepository;

	@Autowired
	private UserDetailsService service;

	@Autowired
	private ProductServiceImpl productservice;

	int uid;

	/*
	 * Once the seller/admin login, It will navigate to the adminhome.
	 */
	@GetMapping("/admin/adminhome/{id}")
	public String adminhome(@PathVariable("id") int id, ModelMap model) {

		System.out.println(id);

		User u = service.getUsername(id);
		System.out.println(service.getUsername(id));
		model.addAttribute("add", u.getName());

		model.addAttribute("user", service.getuser(id));

		return "/admin/adminhome";
	}
	/*
	 * In adminhome, Seller/Admin have options to add new products, manage the
	 * existing products and updateprofile.
	 */

	@PostMapping("/admin/adminhome/{id}")
	public String adminhomepost(@PathVariable("id") int id) {

		ModelAndView view = new ModelAndView("admin/adminhome");
		// System.out.println(id);

		return "admin/adminhome";
	}

	/*
	 * If seller/admin wants to add new products, It will navigate to the
	 * addproducts page.
	 */

	@GetMapping("/admin/products/{id}")
	public String adminproducts(@PathVariable("id") int user_id, Model model) {
		model.addAttribute("user", service.getuser(user_id));

		return "admin/addproducts";
	}

	/*
	 * Seller/Admin enter the details of the products along with the image of
	 * the product.
	 */

	@PostMapping("/admin/products/{id}")
	public String adminadd(@RequestParam(name = "productName") String productName,
			@RequestParam(name = "eimage") MultipartFile file, @RequestParam(name = "price") double price,
			@RequestParam(name = "weight") float weight,
			@RequestParam(name = "productDescription") String productDescription,
			@RequestParam(name = "quantity") int quantity, @PathVariable("id") int user_id) throws IOException {

		byte[] byteArr = file.getBytes();
		String base64Encoded = new String(Base64.getEncoder().encode(byteArr));
		String s = "aaa";
		Products p = new Products(productName, price, weight, productDescription, quantity, base64Encoded, byteArr);
		p.setUserid(user_id);

		productservice.createProduct(p);

		System.out.println(productservice.getAllProducts());

		return "redirect:/admin/adminhome/{id}";
	}
	/*
	 * Seller/Admin can view the existing products added by that particular
	 * seller/admin.
	 */

	@GetMapping("/products/prolist/{id}")
	public String listpro(Model model, @PathVariable("id") int user_id) {

		model.addAttribute("user", service.getuser(user_id));

		model.addAttribute("Products", productservice.getAllproductsbyuser(user_id));

		return "products/prolist";

	}

	/*
	 * Seller/Admin can delete the existing product.
	 */

	@PostMapping("/products/prolist/{id}/{userid}")
	public String DeleteProduct(Model model, @PathVariable("id") int id, @PathVariable("userid") int user_id) {
		productservice.deleteProduct(id);
		return "redirect:/products/prolist/" + user_id;

	}

	/*
	 * If seller/admin wants to update the existing products Navigate to
	 * updateproduct page
	 */
	@GetMapping("/products/updateproduct/{id}")
	public String updateproduct(@PathVariable("id") int id, Model model) {

		model.addAttribute("product", productservice.getProduct(id));

		return "products/updateproduct";
	}

	/*
	 * Seller/Admin can Update the details of the existing products.
	 */

	@PostMapping("/products/updateproduct/{id}")
	public ModelAndView updateProduct(@PathVariable("id") int id, @ModelAttribute Products pro,
			@RequestParam("submit") String submit, Model model) {
		ModelAndView view = new ModelAndView("products/afterupdateprolist");

		Products p = productservice.getProduct(pro.getId());
		pro.setEimage(p.getEimage());
		pro.setImage(p.getImage());
		productservice.updateProduct(pro);
		pro.setUserid(uid);

		model.addAttribute("add", pro.getUserid());
		view.addObject("Products", productservice.getAllproductsbyuser(pro.getUserid()));

		return view;
	}

	/*
	 * If seller/admin wants to update the profile Navigate to updateprofile
	 * page.
	 */
	@GetMapping("/admin/updateProfile/{id}")
	public String adminUpdate(@PathVariable("id") int id, Model model) {
		model.addAttribute("user", service.getuser(id));
		return "/admin/updateProfile";
	}

	/*
	 * Seller/Admin can Update the profile.
	 */

	@PostMapping("/admin/updateProfile/{id}")
	public String adminUpdateInsert(@PathVariable("id") int id, @ModelAttribute User user, Model model) {
		System.out.println("SUCCESS");
		model.addAttribute("user", service.getuser(id));
		service.updateUser(user);

		return "redirect:/admin/adminhome/{id}";
	}

}

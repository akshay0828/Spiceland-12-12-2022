
package com.valtech.spring.security.controllers;

import java.util.Base64;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.valtech.spring.security.dao.ProductDao;
import com.valtech.spring.security.dao.UserDetailsDao;
import com.valtech.spring.security.entity.Products;
import com.valtech.spring.security.entity.User;
import com.valtech.spring.security.service.ProductService;
import com.valtech.spring.security.service.ProductServiceImpl;
import com.valtech.spring.security.service.RoleService;
import com.valtech.spring.security.service.UserDetailsService;

@Controller
public class AdminController {

	@Autowired
	private UserDetailsService service;

	@Autowired
	private ProductService productservice;

	@Autowired
	private RoleService roleService;
	
	

	int uid;
	int flag = 0;

	private static final Logger logger = LoggerFactory.getLogger(AdminController.class);

	/*
	 * Once the seller/admin login, It will navigate to the adminhome.
	 */
	@GetMapping("/admin/adminhome/{id}")
	public String adminhome(@PathVariable("id") int id, ModelMap model) {

		logger.info("Navigating towards SELLER dashboard with the user-id " + id);

		User u = service.getUsername(id);

		model.addAttribute("add", u.getName());

		model.addAttribute("user", service.getuser(id));

		logger.debug("The seller " + u.getName() + "has been succesfully entered the dashboard");

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
		User u = service.getUsername(user_id);
		logger.info("Navigation towards adding new products by the seller " + user_id);

		logger.info("Checking whether the product added is new/existing one");
		if (flag == 1) {
			model.addAttribute("perror", "Product is already added");
			flag = 0;
			// System.out.println("error>>>>>>>>>>");

		}
		return "admin/addproducts";
	}

	/*
	 * Seller/Admin enter the details of the products along with the image of
	 * the product.
	 */

	@PostMapping("/admin/products/{id}")
	@ExceptionHandler(MaxUploadSizeExceededException.class)
	public String adminadd(@RequestParam(name = "productName") String productName,
			@RequestParam(name = "eimage") MultipartFile file, @RequestParam(name = "price") double price,
			@RequestParam(name = "weight") float weight,
			@RequestParam(name = "productDescription") String productDescription,
			@RequestParam(name = "quantity") int quantity, @PathVariable("id") int user_id, Model model)
			throws Exception {

		try {

			logger.info("Working towards logic of image upload");
			byte[] byteArr = file.getBytes();
			int size = byteArr.length;

			logger.debug("The file size " + size + " +bytes");

			// System.out.println("The file size is " + size + " bytes");
			String base64Encoded = new String(Base64.getEncoder().encode(byteArr));

			List<Products> pro = productservice.getProductsbyproductname(productName);

			User u1 = service.getuser(user_id);

			if (pro != null) {
				logger.info("Checking whether the product added is new/existing one");
				for (Products produ : pro) {
					User n = produ.getUser();
					String p = produ.getProductName();

					if (p.equalsIgnoreCase(productName)) {
						if (user_id == n.getId()) {

							flag = 1; // showing status that user has addded the
						} // product already

					}
				}
			}
			if (flag == 1) {

				logger.error(
						"the product " + productName + " is already added to the list by the seller " + u1.getName());
				model.addAttribute("perror", "Product is already added");
				return "redirect:/admin/products/" + user_id;
			}
			Products p = new Products(productName, price, weight, productDescription, quantity, base64Encoded, byteArr);

			User u = service.getuser(user_id);
			p.setUser(u);
			productservice.createProduct(p);
			// p.setUser(u);
			logger.debug("Adding the " + productName + "from the seller " + u1.getName());

			logger.debug("Displaying products " + productservice.getAllproductsbyuser(u) + "added by the seller "
					+ u1.getName());

			// System.out.println(productservice.getAllProducts());
		}

		catch (MaxUploadSizeExceededException e) {

			logger.debug("FILE ERROR");

			// System.out.println("FILE ERROR");
		}

		return "redirect:/admin/adminhome/{id}";
	}

	/*
	 * Seller/Admin can view the existing products added by that particular
	 * seller/admin.
	 */

	@GetMapping("/products/prolist/{id}")
	public String listpro(Model model, @PathVariable("id") int user_id) {

		User user = service.getUsername(user_id);

		logger.info("Displaying the entire product list added by the seller " + user.getName());

		model.addAttribute("user", service.getuser(user_id));
		User u = service.getByid(user_id);
		model.addAttribute("Products", productservice.getAllproductsbyuser(u));

		logger.debug("Displaying products " + productservice.getAllproductsbyuser(u) + "added by the seller "
				+ user.getName());

		return "products/prolist";

	}

	/*
	 * Seller/Admin can delete the existing product.
	 */

	@PostMapping("/products/prolist/{id}/{userid}")
	public String DeleteProduct(Model model, @PathVariable("id") int id, @PathVariable("userid") int user_id) {

		logger.info("Deleting the product");
		Products p = productservice.getProduct(id);
		p.setUser(null);
		productservice.deleteProduct(id);
		
		return "redirect:/products/prolist/" + user_id;

	}

	/*
	 * If seller/admin wants to update the existing products Navigate to
	 * updateproduct page
	 */
	@GetMapping("/products/updateproduct/{id}")
	public String updateproduct(@PathVariable("id") int id, Model model, @ModelAttribute Products pro) {

		logger.info("Navigation towards updating the product");
		model.addAttribute("product", productservice.getProduct(id));

		return "products/updateproduct";
	}

	/*
	 * Seller/Admin can Update the details of the existing products.
	 */

	@PostMapping("/products/updateproduct/{id}")
	public String updateProduct(@PathVariable("id") int id, @ModelAttribute Products pro,
			@RequestParam("submit") String submit, Model model) throws Exception {

		Products products = productservice.getProduct(id);

		try {
			logger.info("Updating the fields required for the existing product_id " + id);

			logger.debug("Existing product details  " + productservice.getProduct(id));

			productservice.productUpdate(pro.getProductName(), pro.getPrice(), pro.getWeight(), pro.getQuantity(),
					pro.getProductDescription(), pro.getId());
			

			model.addAttribute("add", pro.getUser());
			model.addAttribute("Products", productservice.getAllproductsbyuser(products.getUser()));
			logger.debug("Updated details " + productservice.getProduct(id));
		} catch (NullPointerException e) {
			return "redirect:/products/prolist/" + products.getUser().getId();
		}
		return "redirect:/products/prolist/" + products.getUser().getId();
	}

	/*
	 * If seller/admin wants to update the profile Navigate to updateprofile
	 * page.
	 */
	@GetMapping("/admin/updateProfile/{id}")
	public String adminUpdate(@PathVariable("id") int id, Model model) {
		logger.info("Updating required fields");
		model.addAttribute("user", service.getuser(id));
		return "/admin/updateProfile";
	}

	/*
	 * Seller/Admin can Update the profile.
	 */

	@PostMapping("/admin/updateProfile/{id}")
	public String adminUpdateInsert(@PathVariable("id") int id, @ModelAttribute User user, Model model) {

		logger.info("Updating the profile details of the seller " + id);

		model.addAttribute("user", service.getuser(id));

		service.updateUser(user.getName(), user.getEmail(), user.getContact(), user.getStreet(), user.getArea(),
				user.getCity(), user.getPincode(), id);

		logger.debug("Successful updation for the seller " + id);

		return "redirect:/admin/adminhome/{id}";
	}

}
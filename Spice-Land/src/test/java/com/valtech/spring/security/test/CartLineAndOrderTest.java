package com.valtech.spring.security.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.valtech.spring.security.entity.CartLine;
import com.valtech.spring.security.entity.Products;
import com.valtech.spring.security.service.CartLineService;
import com.valtech.spring.security.service.ProductService;

@SpringBootTest
public class CartLineAndOrderTest {
	@Autowired

	private CartLineService cartLineService;

	@Autowired
	private ProductService product;

	@Test
	public void addCartLine() {

		List<Products> p = product.getAllProducts();

		ArrayList<Integer> prodIds = new ArrayList<>();

		if (p.size() > 0) {

			for (Products prod : p) {
				System.out.println("USER_ID CHECKED");

				prodIds.add(prod.getId());

			}
			Products item = product.getProduct(prodIds.get(0));

			CartLine cartLine = new CartLine(item.getId(), item.getProductName(), item.getPrice());
			cartLineService.createCartLine(cartLine);
			System.out.println("ITEM ADDED TO CART");

			assertEquals(item.getProductName(), cartLine.getProductName());
		}

	}
}

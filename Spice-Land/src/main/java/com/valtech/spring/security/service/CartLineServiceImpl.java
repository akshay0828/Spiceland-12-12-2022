
package com.valtech.spring.security.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.valtech.spring.security.entity.CartLine;
import com.valtech.spring.security.repo.CartLineRepo;

@Service
public class CartLineServiceImpl implements CartLineService {

	@Autowired
	private CartLineRepo cartLineRepo;

	// Create new cartitem.
	@Override
	public void createCartLine(CartLine cartline) {
		cartLineRepo.save(cartline);
	}

	// List of cartitems .
	@Override
	public List<CartLine> findAll() {
		return cartLineRepo.findAll();
	}

	// To get the cartitems by id.
	@Override
	public CartLine findById(int id) {
		return cartLineRepo.findById(id).get();
	}

	// To get the product id of the items added to the cart.
	@Override
	public CartLine findByProId(int prodid) {
		return cartLineRepo.findByprodid(prodid);
		// Delete the cartline item.
	}

	@Override
	public void deleteCartLine(int id) {
		cartLineRepo.deleteById(id);
	}

	// List of the items id added to the cart.
	@Override
	public ArrayList<Integer> findAllId(int id) {
		List<CartLine> cart = cartLineRepo.findAll();
		ArrayList<Integer> cid = new ArrayList<>();

		for (CartLine cartLine : cart) {
			if (id == cartLine.getUserid()) {
				cid.add(cartLine.getId());
			}
		}

		return cid;
	}

	// List of admin id's of the items in the cart.
	@Override
	public ArrayList<Integer> findAllAdminId(int id) {
		List<CartLine> cart = cartLineRepo.findAll();
		ArrayList<Integer> cid = new ArrayList<>();

		for (CartLine cartLine : cart) {
			if (id == cartLine.getUserid()) {
				cid.add(cartLine.getAdminIds());
			}
		}

		return cid;
	}

	// To get the cartitem by user id.
	@Override
	public int findid(int id) {
		return cartLineRepo.findIdByUserid(id);

	}

	// To get all the items particular to the buyer.
	@Override
	public List<CartLine> getAllordersByuserid(int userid) {

		return cartLineRepo.findByUserid(userid);

	}

	// To get the user id by user id and product id.
	@Override
	public int findUserIdAndProdId_onlyUserId(int userid, int prodid) {

		CartLine check = cartLineRepo.findByUseridAndProdid(userid, prodid);

		if (userid == check.getUserid()) {
			return check.getUserid();
		}

		return 0;
	}

	// To get the product id by user id and product id.
	@Override
	public int findUserIdAndProdId_onlyProdId(int userid, int prodid) {

		CartLine check = cartLineRepo.findByUseridAndProdid(userid, prodid);

		if (prodid == check.getProdid()) {
			return check.getProdid();
		}

		return 0;
	}

	// To get both userid and product id.
	@Override
	public CartLine findUserIdAndProdId(int userid, int prodid) {

		CartLine check = cartLineRepo.findByUseridAndProdid(userid, prodid);

		return cartLineRepo.findByUseridAndProdid(userid, prodid);
	}

	// To clear the cart items by user id.
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public Object EmptyCart(int userid) {

		return cartLineRepo.deleteByUserid(userid);

	}
}

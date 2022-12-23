
package com.valtech.spring.security.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

	private static final Logger logger = LoggerFactory.getLogger(CartLineServiceImpl.class);

	// Create new cartitem.
	@Override
	public void createCartLine(CartLine cartline) {
		logger.info("Adding items to cart");
		cartLineRepo.save(cartline);
	}

	// List of cartitems .
	@Override
	public List<CartLine> findAll() {
		logger.info("List of items to be viewed");
		return cartLineRepo.findAll();
	}

	// To get the cartitems by id.
	@Override
	public CartLine findById(int id) {
		logger.info("Fetching id" + id);
		return cartLineRepo.findById(id).get();
	}

	// To get the product id of the items added to the cart.
	@Override
	public CartLine findByProId(int prodid) {
		logger.info("Fetching order with productId " + prodid);
		return cartLineRepo.findByprodid(prodid);
		// Delete the cartline item.
	}

	@Override
	public void deleteCartLine(int id) {
		logger.info("Deleting the order wit " + id);
		cartLineRepo.deleteById(id);
	}

	// List of the items id added to the cart.
	@Override
	public ArrayList<Integer> findAllId(int id) {
		logger.info("Getting all list of items to the cart ");
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
		logger.info("Getting all seller IDs in the cart ");
		List<CartLine> cart = cartLineRepo.findAll();
		ArrayList<Integer> cid = new ArrayList<>();

		for (CartLine cartLine : cart) {
			if (id == cartLine.getUserid()) {
				if (cid.contains(cartLine.getAdminIds())) {
				} else {
					cid.add(cartLine.getAdminIds());
				}
			}
		}
		return cid;
	}

	// To get the cartitem by user id.
	@Override
	public int findid(int id) {

		logger.info("Fetching item with id " + id);
		return cartLineRepo.findIdByUserid(id);

	}

	// To get all the items particular to the buyer.
	@Override
	public List<CartLine> getAllordersByuserid(int userid) {
		logger.info("Getting all orders with userID " + userid);
		return cartLineRepo.findByUserid(userid);
	}

	// To get the user id by user id and product id.
	@Override
	public int findUserIdAndProdId_onlyUserId(int userid, int prodid) {
		logger.info("Fetching both userID" + userid + "along with prodID " + prodid);
		CartLine check = cartLineRepo.findByUseridAndProdid(userid, prodid);
		if (userid == check.getUserid()) {
			return check.getUserid();
		}
		return 0;
	}

	// To get the product id by user id and product id.
	@Override
	public int findUserIdAndProdId_onlyProdId(int userid, int prodid) {
		logger.info("Fetching both userID" + userid + "along with prodID " + prodid);

		CartLine check = cartLineRepo.findByUseridAndProdid(userid, prodid);
		if (prodid == check.getProdid()) {
			return check.getProdid();
		}
		return 0;
	}

	// To get both userid and product id.
	@Override
	public CartLine findUserIdAndProdId(int userid, int prodid) {
		logger.info("Fetching both userID" + userid + "along with prodID " + prodid);

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

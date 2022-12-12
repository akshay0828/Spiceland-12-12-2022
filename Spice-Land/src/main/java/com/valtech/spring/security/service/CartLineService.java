package com.valtech.spring.security.service;

import java.util.ArrayList;
import java.util.List;

import com.valtech.spring.security.entity.CartLine;

public interface CartLineService {

	void createCartLine(CartLine cartline);

	List<CartLine> findAll();

	CartLine findById(int id);

	CartLine findByProId(int prodid);

	void deleteCartLine(int id);

	ArrayList<Integer> findAllId(int id);

	ArrayList<Integer> findAllAdminId(int id);

	int findid(int id);

	List<CartLine> getAllordersByuserid(int userid);

	int findUserIdAndProdId_onlyUserId(int userid, int prodid);

	int findUserIdAndProdId_onlyProdId(int userid, int prodid);

	CartLine findUserIdAndProdId(int userid, int prodid);

	Object EmptyCart(int userid);

}
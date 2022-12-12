package com.valtech.spring.security.service;

import java.util.ArrayList;
import java.util.List;

import com.valtech.spring.security.entity.CartLine;

public interface CartLineService {
	List<CartLine> findAll();

	void createCartLine(CartLine cartline);



	CartLine findByProId(int prodid);

	CartLine findById(int id);

	void deleteCartLine(int id);



List<CartLine> getAllordersByuserid(int userid);
	
	int findid(int id);

	ArrayList<Integer> findAllId(int id);

	ArrayList<Integer> findAllAdminId(int id);

	int findUserIdAndProdId_onlyUserId(int userid, int prodid);

	int findUserIdAndProdId_onlyProdId(int userid, int prodid);

	CartLine findUserIdAndProdId(int userid, int prodid);

	Object EmptyCart(int userid);


}
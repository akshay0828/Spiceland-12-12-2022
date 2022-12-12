package com.valtech.spring.security.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.valtech.spring.security.entity.CartLine;

@Repository
public interface CartLineRepo extends JpaRepository<CartLine, Integer> {
	
	
	CartLine findByprodid(int prodid);

	int findIdByUserid(int userid);
	
	List<CartLine> findByUserid(int userid);
	
	CartLine findByUseridAndProdid(int userid,int prodid);
	
	Object deleteByUserid(int userid);

}

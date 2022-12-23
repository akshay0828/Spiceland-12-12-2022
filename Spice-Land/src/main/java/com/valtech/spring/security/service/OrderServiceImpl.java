package com.valtech.spring.security.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.valtech.spring.security.entity.Orders;
import com.valtech.spring.security.repo.OrderRepository;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderRepository orderRepository;

	private static final Logger logger = LoggerFactory.getLogger(OrderServiceImpl.class);

	// Add new orders.
	@Override
	public void saveOrder(Orders orders) {
		logger.info("saving the order");
		orderRepository.save(orders);

	}

	// List of orders.
	@Override
	public List<Orders> findAll() {
		logger.info("Fetching all list of orders");
		return orderRepository.findAll();
	}

	// Finding whether the order is their or not.
	@Override
	public boolean existsById(Integer id) {
		logger.info("Existence of orders");
		return orderRepository.existsById(id);
	}

	// Delete the order.
	@Override
	public void delete(Orders entity) {
		logger.info("deleting order");
		orderRepository.delete(entity);
	}

	// Get the details of order by id.
	@Override
	public Orders getById(Integer id) {
		logger.info("Fetching order with id " + id);
		return orderRepository.getById(id);
	}

	// Delete the order.
	@Override
	public void deletebyId(int id) {
		logger.info("deleting order with id" + id);
		orderRepository.deleteById(id);
	}

	@Override
	public List<Orders> FindByArea(String area) {

		return orderRepository.findByArea(area);

	}

}

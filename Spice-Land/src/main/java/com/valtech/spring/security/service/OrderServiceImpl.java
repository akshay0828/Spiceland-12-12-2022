package com.valtech.spring.security.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.valtech.spring.security.entity.Orders;
import com.valtech.spring.security.repo.OrderRepository;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderRepository orderRepository;

	// Add new orders.
	@Override
	public void saveOrder(Orders orders) {
		orderRepository.save(orders);

	}

	// List of orders.
	@Override
	public List<Orders> findAll() {
		return orderRepository.findAll();
	}

	// Finding whether the order is their or not.
	@Override
	public boolean existsById(Integer id) {
		return orderRepository.existsById(id);
	}

	// Delete the order.
	@Override
	public void delete(Orders entity) {
		orderRepository.delete(entity);
	}

	// Get the details of order by id.
	@Override
	public Orders getById(Integer id) {
		return orderRepository.getById(id);
	}

	// Delete the order.
	@Override
	public void deletebyId(int id) {
		orderRepository.deleteById(id);
	}

}

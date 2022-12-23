package com.valtech.spring.security.entity;

import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Orders {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int id;// unique constraint of the Order .
	private ArrayList<Integer> cartIds;// List of the id's of cartitems.
	private String orderDate;// Date on which order is placed.
	private int user_id;// user id ,who placed the order.
	private String area;
	private ArrayList<Integer> adminIds;

	public Orders() {
		super();
	}

	public Orders(int id, ArrayList<Integer> cartIds, String orderDate, int user_id, ArrayList<Integer> adminIds,
			String area) {
		super();
		this.id = id;
		this.cartIds = cartIds;
		this.orderDate = orderDate;
		this.user_id = user_id;
		this.adminIds = adminIds;
		this.area = area;
	}

	public Orders(ArrayList<Integer> cartIds, String orderDate, int user_id, ArrayList<Integer> adminIds, String area) {
		super();
		this.cartIds = cartIds;
		this.orderDate = orderDate;
		this.user_id = user_id;
		this.adminIds = adminIds;
		this.area = area;
	}

	// Getters and Setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public ArrayList<Integer> getCartIds() {
		return cartIds;
	}

	public void setCartIds(ArrayList<Integer> cartIds) {
		this.cartIds = cartIds;
	}

	public String getDate() {
		return orderDate;
	}

	public void setDate(String orderDate) {
		this.orderDate = orderDate;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public ArrayList<Integer> getAdminIds() {
		return adminIds;
	}

	public void setAdminIds(ArrayList<Integer> adminIds) {
		this.adminIds = adminIds;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	@Override
	public String toString() {
		return "Orders [id=" + id + ", cartIds=" + cartIds + ", date=" + orderDate + ", user_id=" + user_id + ", area="
				+ area + ", adminIds=" + adminIds + "]";
	}

}

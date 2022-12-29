package com.valtech.spring.security.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;



@Entity
public class CartLine {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int id;// unique constraint of the cart item.
	
	
	private int prodid;// product id of the item.
	
	
	private String productName;// name of the product
	private double price;// Price of the product.
	private int quantity = 1;// Quantity of the item.

	private int adminIds;

	private int userid;

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public CartLine(int prodid, String productName, double price) {
		super();
		this.prodid = prodid;
		this.productName = productName;
		this.price = price;

	}

	public CartLine(int prodid, String productName, double price, int adminIds, int userid) {
		super();
		this.prodid = prodid;
		this.productName = productName;
		this.price = price;
		this.userid = userid;
		this.adminIds = adminIds;
	}

	public CartLine(int id, int prodid, String productName, double price, int quantity, int adminIds) {
		super();
		this.id = id;
		this.prodid = prodid;
		this.productName = productName;
		this.price = price;
		this.quantity = quantity;
		this.adminIds = adminIds;
	}

	public CartLine() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getProdid() {
		return prodid;
	}

	public void setProdid(int prodid) {
		this.prodid = prodid;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getAdminIds() {
		return adminIds;
	}

	public void setAdminIds(int adminIds) {
		this.adminIds = adminIds;
	}

	@Override
	public String toString() {
		return "CartLine [id=" + id + ", prodid=" + prodid + ", productName=" + productName + ", price=" + price
				+ ", quantity=" + quantity + ", adminIds=" + adminIds + "]";
	}

}

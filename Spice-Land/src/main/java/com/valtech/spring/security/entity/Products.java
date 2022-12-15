package com.valtech.spring.security.entity;

import java.util.Arrays;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

@Entity
public class Products {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;// Unique Constraint of the product.
	private String productName;// Name of the product.
	private double price;// Price of the product.
	private float weight;// Weight of the product.
	private String productDescription;// Description of the product.
	private int quantity;// Quantity of the product avaliable.
	@Lob
	@Column(columnDefinition = "MEDIUMBLOB")
	private String image;

	@Lob
	@Column(name = "EIMAGE")
	private byte[] eimage;

	private int userid;

	// Parameterless Constructor
	public Products() {
	}

	public Products(String productName, double price, float weight, String productDescription, int quantity,
			String image, byte[] eimage) {
		super();
		this.productName = productName;
		this.price = price;
		this.weight = weight;
		this.productDescription = productDescription;
		this.quantity = quantity;
		this.image = image;
		this.eimage = eimage;

	}

	public Products(String productName, double price, float weight, String productDescription, int quantity,
			String image, int userid) {
		super();
		this.productName = productName;
		this.price = price;
		this.weight = weight;
		this.productDescription = productDescription;
		this.quantity = quantity;
		this.image = image;
		this.userid = userid;
	}

	public Products(int id, String productName, double price, float weight, String productDescription, int quantity,
			String image, byte[] eimage, int userid) {
		super();
		this.id = id;
		this.productName = productName;
		this.price = price;
		this.weight = weight;
		this.productDescription = productDescription;
		this.quantity = quantity;
		this.image = image;
		this.eimage = eimage;
		this.userid = userid;
	}

	// Getters and Setters of the variables.

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public float getWeight() {
		return weight;
	}

	public void setWeight(float weight) {
		this.weight = weight;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public byte[] getEimage() {
		return eimage;
	}

	public void setEimage(byte[] eimage) {
		this.eimage = eimage;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	@Override
	public String toString() {
		return "Products [id=" + id + ", productName=" + productName + ", price=" + price + ", weight=" + weight
				+ ", productDescription=" + productDescription + ", quantity=" + quantity + "]";
	}

}

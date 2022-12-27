package com.valtech.spring.security.entity;

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
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int id;// Unique Constraint of the product.
	private String productName;// Name of the product.
	private double price;// Price of the product.
	private float weight;// Weight of the product.
	private String productDescription;// Description of the product.
	private int quantity;// Quantity of the product avaliable.

	@Lob
	// @Column(columnDefinition = "MEDIUMBLOB")
	private String image;

	@Lob
	@Column(name = "EIMAGE")
	private byte[] eimage;

	@ManyToOne(targetEntity = User.class, cascade = { CascadeType.MERGE, CascadeType.PERSIST }, fetch = FetchType.EAGER)
	@JoinColumn(name = "user_id", referencedColumnName = "id")
	private User user;
	// Parameterless Constructor

	public Products() {
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
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

	public Products(int id, String productName, double price, float weight, String productDescription, int quantity,
			String image, byte[] eimage, User user) {
		super();
		this.id = id;
		this.productName = productName;
		this.price = price;
		this.weight = weight;
		this.productDescription = productDescription;
		this.quantity = quantity;
		this.image = image;
		this.eimage = eimage;
		this.user = user;
	}

	public Products(String productName, double price, float weight, String productDescription, int quantity,
			String image) {
		super();
		this.productName = productName;
		this.price = price;
		this.weight = weight;
		this.productDescription = productDescription;
		this.quantity = quantity;
		this.image = image;
	}

	public Products(int id, String productName, double price, float weight, String productDescription, int quantity,
			String image, User user) {
		super();
		this.id = id;
		this.productName = productName;
		this.price = price;
		this.weight = weight;
		this.productDescription = productDescription;
		this.quantity = quantity;
		this.image = image;
		this.eimage = eimage;
		this.user = user;
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

}

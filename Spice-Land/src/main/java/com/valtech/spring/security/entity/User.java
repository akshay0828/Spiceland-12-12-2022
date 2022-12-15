package com.valtech.spring.security.entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Table(name = "users")
public class User implements UserDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id; // unique constraint of the user.
	private String name; // Name of the user.
	private String email; // Email of the user.
	private String username;// Username of the user.
	private String pass;// Password of the use.
	private String cnfmpass;// Confirm the password .
	private String street;// Address of the user.
	private String area;// Address of the user.
	private String city;// Address of the user.
	private String pincode;// Address of the user.
	private String contact;// Contact information of the user.
	private boolean enabled;
	private String role;// Role of the user

	@ElementCollection(fetch=FetchType.EAGER)
	@CollectionTable(name="user_roles1",joinColumns=@JoinColumn(name="user_id",referencedColumnName="id"))
	@Column(name="role_name")

	private List<String> roles;
	
	
	public User() {

		roles = new ArrayList<>();
	}
	
	

	
	public User(String name, String email, String username, String pass, String cnfmpass, String street, String area,
			String city, String pincode, String contact, boolean enabled, String role, List<String> roles) {
		super();
		this.name = name;
		this.email = email;
		this.username = username;
		this.pass = pass;
		this.cnfmpass = cnfmpass;
		this.street = street;
		this.area = area;
		this.city = city;
		this.pincode = pincode;
		this.contact = contact;
		this.enabled = enabled;
		this.role = role;
		this.roles = roles;
	}



	



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getUsername() {
		return username;
	}



	public void setUsername(String username) {
		this.username = username;
	}



	public String getPass() {
		return pass;
	}



	public void setPass(String pass) {
		this.pass = pass;
	}



	public String getCnfmpass() {
		return cnfmpass;
	}



	public void setCnfmpass(String cnfmpass) {
		this.cnfmpass = cnfmpass;
	}



	public String getStreet() {
		return street;
	}



	public void setStreet(String street) {
		this.street = street;
	}



	public String getArea() {
		return area;
	}



	public void setArea(String area) {
		this.area = area;
	}



	public String getCity() {
		return city;
	}



	public void setCity(String city) {
		this.city = city;
	}



	public String getPincode() {
		return pincode;
	}



	public void setPincode(String pincode) {
		this.pincode = pincode;
	}



	public String getContact() {
		return contact;
	}



	public void setContact(String contact) {
		this.contact = contact;
	}



	public boolean isEnabled() {
		return enabled;
	}



	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}



	public String getRole() {
		return role;
	}



	public void setRole(String role) {
		this.role = role;
	}



	public List<String> getRoles() {
		return roles;
	}



	public void setRoles(List<String> roles) {
		this.roles = roles;
	}



	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return roles.stream().map(role->new SimpleGrantedAuthority(role)).collect(Collectors.toList());
	}



	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return enabled;
	}



	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return enabled;
	}



	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return enabled;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return null;
	}




	

	
}

package com.example.demo.entities;

import jakarta.persistence.*;

@Entity
@Table(name="adress")
public class Address {
	
	//fields
	@Id
	@Column(name="address_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int address_id;
	
	@Column(name="address_line1")
	private String address_line1;
	
	@Column(name="address_line2")
	private String address_line2;
	
	@Column(name="city")
	private String city;
	
	@Column(name="district")
	private String district;
	
	@Column(name="zipcode")
	private int zipcode;

	@Column(name="state")
	private String state;
	
	@Column(name="country")
	private String country;

	
	
	//getters and setters
	public int getAddress_id() {
		return address_id;
	}

	public void setAddress_id(int address_id) {
		this.address_id = address_id;
	}

	public String getAddress_line1() {
		return address_line1;
	}

	public void setAddress_line1(String address_line1) {
		this.address_line1 = address_line1;
	}

	public String getAddress_line2() {
		return address_line2;
	}

	public void setAddress_line2(String address_line2) {
		this.address_line2 = address_line2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public int getZipcode() {
		return zipcode;
	}

	public void setZipcode(int zipcode) {
		this.zipcode = zipcode;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	
	//tostring
	@Override
	public String toString() {
		return "Address [address_id=" + address_id + ", address_line1=" + address_line1 + ", address_line2="
				+ address_line2 + ", city=" + city + ", district=" + district + ", zipcode=" + zipcode + ", state="
				+ state + ", country=" + country + "]";
	}
	
	
	//constructors

	public Address() {
		
	}
	public Address(String address_line1, String address_line2, String city, String district, int zipcode, String state,
			String country) {
		super();
		this.address_line1 = address_line1;
		this.address_line2 = address_line2;
		this.city = city;
		this.district = district;
		this.zipcode = zipcode;
		this.state = state;
		this.country = country;
	}
	
	
	
	
	
	
}

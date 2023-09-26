package com.example.demo.entities;

import java.util.ArrayList;
import java.util.List;

//import java.util.ArrayList;
//import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name="customer")
public class Customer {
	
	
	
	//fields
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="customer_id")
	private int customer_id;
	
	@Column(name="first_name")
	private String first_name;
	
	@Column(name="last_name")
	private String last_name;
	
	@Column(name="email")
	private String email;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="customer_address_id")
	private Address address;

    @OneToMany(mappedBy="customer",fetch=FetchType.EAGER,cascade= {CascadeType.MERGE,CascadeType.PERSIST})
    private List<Customer_Policy> customer_policy_list;
	
  
	//getter and setters
	


	


//	public ArrayList<Policy> getPolicies() {
//		return policies;
//	}
//
//	public void setPolicies(ArrayList<Policy> policies) {
//		this.policies = policies;
//	}

	public int getCustomer_id() {
		return customer_id;
	}

//	public List<Customer_Policy> getCustomer_policy() {
//		return customer_policy_list;
//	}
//
//	public void setCustomer_policy(List<Customer_Policy> customer_policy) {
//		this.customer_policy_list = customer_policy;
//	}



	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}

	public List<Customer_Policy> getCustomer_policy_list() {
		return customer_policy_list;
	}

	public void setCustomer_policy_list(List<Customer_Policy> customer_policy_list) {
		this.customer_policy_list = customer_policy_list;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}


	//constructors 
	public Customer(){}
	
	
	public Customer(String first_name, String last_name, String email) {
		super();
		this.first_name = first_name;
		this.last_name = last_name;
		this.email = email;
	}
	
	//toString()
//
//	@Override
//	public String toString() {
//		return "Customer [customer_id=" + customer_id + ", first_name=" + first_name + ", last_name=" + last_name
//				+ ", email=" + email + ", address=" + address + ", customer_policy_list=" + customer_policy_list + "]";
//	}


	
//	
	//convenience method
	public void addCustomerPolicy(Customer_Policy customer_policy) {
		if(customer_policy_list==null) {
			customer_policy_list=new ArrayList<>();
		}
		customer_policy_list.add(customer_policy);
	}

}


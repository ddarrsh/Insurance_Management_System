package com.example.demo.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name="agent")
public class Agent {
	
	//fields
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="agent_id")
	private int agent_id;
	
	@Column(name="first_name")
	private String first_name;
	
	@Column(name="last_name")
	private String last_name;
	
	@Column(name="email")
	private String email;
	
	@OneToOne(cascade=CascadeType.ALL )
	@JoinColumn(name="agent_address_id")
	private Address address;
	


	@OneToMany(mappedBy="agent",fetch=FetchType.EAGER)
	private List<Customer_Policy> customer_policy_list;

	
	//getters and setter

	public List<Customer_Policy> getCustomer_policy() {
		return customer_policy_list;
	}

	public void setCustomer_policy(List<Customer_Policy> customer_policy_list) {
		this.customer_policy_list = customer_policy_list;
	}

	
	public int getAgent_id() {
		return agent_id;
	}

	public void setAgent_id(int agent_id) {
		this.agent_id = agent_id;
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
	public Agent() {}
	public Agent(String first_name, String last_name, String email) {
		super();
		this.first_name = first_name;
		this.last_name = last_name;
		this.email = email;
	}

	
	//toString()
	@Override
	public String toString() {
		return "Agent [agent_id=" + agent_id + ", first_name=" + first_name + ", last_name=" + last_name + ", email="
				+ email + ", address=" + address + "]";
	}
	
	
	//Convenience Method
	
	public void addCustomerPolicy(Customer_Policy customer_policy) {
		if(customer_policy_list==null) {
			customer_policy_list=new ArrayList<>();
		}
		customer_policy_list.add(customer_policy);
	}
}

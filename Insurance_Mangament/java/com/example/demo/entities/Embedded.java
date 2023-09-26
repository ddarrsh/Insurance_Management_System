package com.example.demo.entities;

import jakarta.persistence.*;

@Embeddable
public class Embedded{
	@ManyToOne(cascade= {CascadeType.MERGE,CascadeType.PERSIST})
	@JoinColumn(name="customer_id")
	private Customer customer;
	
	@ManyToOne(cascade= {CascadeType.MERGE,CascadeType.PERSIST})
	@JoinColumn(name="policy_id")
	private Policy policy;

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Policy getPolicy() {
		return policy;
	}

	public void setPolicy(Policy policy) {
		this.policy = policy;
	}


	

}

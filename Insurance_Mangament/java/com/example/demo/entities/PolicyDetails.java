package com.example.demo.entities;


import jakarta.persistence.*;

@Entity
@Table(name="policyDetails")
public class PolicyDetails {
	
	//fields
	
	@OneToOne(mappedBy="PolicyDetails")
	private Policy policy;
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="details_id")
	private int details_id;
	
	
	@Column(name="policy_number")
	private long policy_number;
	
	@Column(name="coverage_type")
	private String coverage_type;
	
	//Benefits of policy
	@Column(name="coverage_description")
	private String coverage_description;

	//only for back end reference no need to display maturity amount instead provide
	//front end calculator with predefined formuLas for customer to calculate it.
	//no need to add in constructor parameters define some criteria in body , i.e set
	//it to according to tenure and some percentage 
	@Column(name="maturity_amount")
	private int maturity_amount;
	
	
	//getters and setters

	

	public int getMaturity_amount() {
		return maturity_amount;
	}


	public void setMaturity_amount(int maturity_amount) {
		this.maturity_amount = maturity_amount;
	}


	public Policy getPolicy() {
		return policy;
	}


	public void setPolicy(Policy policy) {
		this.policy = policy;
	}


	public int getDetails_id() {
		return details_id;
	}


	public void setDetails_id(int details_id) {
		this.details_id = details_id;
	}


	public long getPolicy_number() {
		return policy_number;
	}


	public void setPolicy_number(long policy_number) {
		this.policy_number = policy_number;
	}


	public String getCoverage_type() {
		return coverage_type;
	}


	public void setCoverage_type(String coverage_type) {
		this.coverage_type = coverage_type;
	}


	public String getCoverage_description() {
		return coverage_description;
	}


	public void setCoverage_description(String coverage_description) {
		this.coverage_description = coverage_description;
	}

	
	//constructors
	public PolicyDetails() {}

	


	public PolicyDetails(long policy_number, String coverage_type, String coverage_description, int maturity_amount) {
		super();
		this.policy_number = policy_number;
		this.coverage_type = coverage_type;
		this.coverage_description = coverage_description;
		this.maturity_amount=maturity_amount;
	}


	@Override
	public String toString() {
		return "PolicyDetails [policy=" + policy + ", details_id=" + details_id + ", policy_number=" + policy_number
				+ ", coverage_type=" + coverage_type + ", coverage_description=" + coverage_description + "]";
	}

	
	
}

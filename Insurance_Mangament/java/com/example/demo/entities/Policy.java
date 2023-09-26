package com.example.demo.entities;

import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name="policy")
public class Policy {

	//fields
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="policy_id")
	private int policy_id;
	
	@Column(name="policy_name")
	private String policy_name;
	
	@Column(name="policy_type")
	private String policy_type;
	
	@Column(name="premium_cost")
	private int premium_cost;
	
	@Column(name="rating")
	private Float rating;
	
	
	@Column(name="tenure")
	private int tenure;
	
	@Column(name="claim_percentage")
	private int claim_percentage;
	
	
	@Column(name="sum_assured")
	private int sum_assured;
	
	



	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="Policy_Details_Id")
	private PolicyDetails PolicyDetails;

	
	@OneToMany(mappedBy="policy",fetch=FetchType.EAGER)
	private List<Customer_Policy> customer_policy_list;
	
//	@Transient
//	private List<Customer> customers;
////	
	
	
	//getters and setters

	
//	public List<Customer> getCustomers() {
//		return customers;
//	}
//
//
//
//
//	public void setCustomers(List<Customer> customers) {
//		this.customers = customers;
//	}




	public int getPolicy_id() {
		return policy_id;
	}




	public List<Customer_Policy> getCustomer_policy_list() {
		return customer_policy_list;
	}




	public void setCustomer_policy_list(List<Customer_Policy> customer_policy_list) {
		this.customer_policy_list = customer_policy_list;
	}




	public void setPolicy_id(int policy_id) {
		this.policy_id = policy_id;
	}




	public String getPolicy_name() {
		return policy_name;
	}




	public void setPolicy_name(String policy_name) {
		this.policy_name = policy_name;
	}




	public String getPolicy_type() {
		return policy_type;
	}




	public void setPolicy_type(String policy_type) {
		this.policy_type = policy_type;
	}




	public int getPremium_cost() {
		return premium_cost;
	}




	public void setPremium_cost(int premium_cost) {
		this.premium_cost = premium_cost;
	}




	public Float getRating() {
		return rating;
	}




	public void setRating(Float rating) {
		this.rating = rating;
	}




	public int getTenure() {
		return tenure;
	}




	public void setTenure(int tenure) {
		this.tenure = tenure;
	}




	public int getClaim_percentage() {
		return claim_percentage;
	}




	public void setClaim_percentage(int claim_percentage) {
		this.claim_percentage = claim_percentage;
	}




	public int getSum_assured() {
		return sum_assured;
	}




	public void setSum_assured(int sum_assured) {
		this.sum_assured = sum_assured;
	}




	public PolicyDetails getPolicyDetails() {
		return PolicyDetails;
	}




	public void setPolicyDetails(PolicyDetails policyDetails) {
		PolicyDetails = policyDetails;
	}



//	public List<Customer_Policy> getCustomer_policy_list() {
//		return customer_policy_list;
//	}
//
//
//
//
//	public void setCustomer_policy_list(List<Customer_Policy> customer_policy_list) {
//		this.customer_policy_list = customer_policy_list;
//	}
//
	

	//constructors

	




	public Policy() {}




	public Policy(String policy_name, String policy_type, int premium_cost, Float rating, int tenure,
			int claim_percentage) {
		super();
		this.policy_name = policy_name;
		this.policy_type = policy_type;
		this.premium_cost = premium_cost;
		this.rating = rating;
		this.tenure = tenure;
		this.claim_percentage = claim_percentage;
		this.sum_assured=(int) (premium_cost * tenure * 12 * Math.pow((1+ (int)8/1),1* tenure));
	}




	//toString
//
//	@Override
//	public String toString() {
//		return "Policy [policy_id=" + policy_id + ", policy_name=" + policy_name + ", policy_type=" + policy_type
//				+ ", premium_cost=" + premium_cost + ", rating=" + rating + ", tenure=" + tenure + ", claim_percentage="
//				+ claim_percentage + ", sum_assured=" + sum_assured + ", PolicyDetails=" + PolicyDetails
//				+ ", customer_policy_list=" + customer_policy_list + "]";
//	}


	
	
//	convenience method

	
//	public void addCustomerPolicy(Customer_Policy customer_policy)
//	{
//		if (customer_policy_list==null)
//			customer_policy_list=new ArrayList<>();
//		customer_policy_list.add(customer_policy);
//		addPolicy();
//	}
//	
//	
//	public void addPolicy() {
//		if(customers==null) {
//			customers=new ArrayList<>();
//		}
//		for(Customer_Policy cp:customer_policy_list)
//			customers.add(cp.e.getCustomer());
//	}
//
//
//


	}





	
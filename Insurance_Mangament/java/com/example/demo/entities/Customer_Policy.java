package com.example.demo.entities;

import java.time.LocalDate;

import jakarta.persistence.*;

@Entity
@Table(name="customer_policy")

public class Customer_Policy{
	
//	@Id
//	@GeneratedValue(strategy=GenerationType.IDENTITY)
//	@Column(name="customer_policy_id")
//	private int customer_policy_id;
//	
	
	@EmbeddedId
	Embedded e;
	
	//you can access the details of the policy bought from the standard policy table.
	//fields
	//automatically refers the PK of `customer` table due to m:n
	
	
	//brought outside to map to customer and policy class for lists
	
	@ManyToOne
	@MapsId("customer")
	@JoinColumn(name="customer_id")
	private Customer customer;
	
	@ManyToOne
	@MapsId("policy")
	@JoinColumn(name="policy_id")
	private Policy policy;

	
	
	
	
	
//	@ManyToOne
//	@JoinColumn(name="customer_id")
//	private Customer customer;
//	//automatically refers the PK of `policy` table due to m:n


	//bidirectional mapping to be able to save commission while creating customer 
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="commission_id")
	private Agent_Commission agent_commission;
	


//	@ManyToOne
//	@JoinColumn(name="policy_id")
//	private Policy policy;

	
	
	//checkpoint
	//policy premium cost can be taken from the respective policy id refering to the 
	//self object's policy_id that will give the respective policy's premium amount
//	@Column(name="premium_cost")
//	private int premium_cost;

	//maturity_amount- take from policydetails
	
	
	@Column(name="purchase_date",columnDefinition="DATE")
	private LocalDate purchaseDate;

	
	//for Agent_Commision
//	@OneToOne(mappedBy="customer_policy")
//	private Agent_Commission agent_commission;
	//do not cascade type all since if you delete a customer_policy then it would delete the agent itself
	@ManyToOne(cascade= {CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
	@JoinColumn(name="agent_id")
	private Agent agent;



	//getters and setters
	

	public Embedded getE() {
		return e;
	}


	public void setE(Embedded e) {
		this.e = e;
	}


	public Agent_Commission getAgent_commission() {
		return agent_commission;
	}


	public void setAgent_commission(Agent_Commission agent_commission) {
		this.agent_commission = agent_commission;
	}


	public LocalDate getPurchaseDate() {
		return purchaseDate;
	}


	public void setPurchaseDate(LocalDate purchaseDate) {
		this.purchaseDate = purchaseDate;
	}


	public Agent getAgent() {
		return agent;
	}


	public void setAgent(Agent agent) {
		this.agent = agent;
	}



	//Constructors

	public Customer_Policy() {
	}
	public Customer_Policy(Customer customer,Policy policy, LocalDate purchaseDate, Agent agent) {
		super();
		this.e =new Embedded();
		this.e.setPolicy(policy);
		this.e.setCustomer(customer);
		
		//adding agent commission here only or we can add once customerpolicy object is 
		// created and in the next line creating agent commission object and
		//using customerpolicy.setAgentCommission(_
		Agent_Commission ac=new Agent_Commission(policy,customer,agent);
		this.setAgent_commission(ac);
		this.purchaseDate = purchaseDate;
		this.agent = agent;
	}


	@Override
	public String toString() {
		return "Customer_Policy [e=" + e + ", agent_commission=" + agent_commission + ", purchaseDate=" + purchaseDate
				+ ", agent=" + agent + "]";
	}


	
	//to add the customer and his/her policy in this table, find the customer object
	//by its id from the session and create  a entry(call the constructor of customer_policy) 
	// passing the customer object to it.
	
	//don't forget to add the customer in the policyList of that Customer and customerList of that Policy
	// in the policyList and customerList fields of respective classes



}

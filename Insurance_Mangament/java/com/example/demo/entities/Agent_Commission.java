package com.example.demo.entities;
import jakarta.persistence.*;

@Entity
@Table(name="agent_commission")
public class Agent_Commission {

	// fields
//	
////	@Id
////	@GeneratedValue(strategy=GenerationType.IDENTITY)
////	@Column(name="commission_id")
////	private int commission_id;
//	
//	@Id
//	@GeneratedValue(strategy=GenerationType.IDENTITY)
//	@Column(name="agent_commission_id")
//	private int agent_commission_id;
//	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="agent_commission_id")
	private int agent_commission_id;
	
	
	//check once if not working, add a join column here
	@OneToOne(mappedBy="agent_commission",cascade=CascadeType.ALL)
	Customer_Policy customer_policy;
	
	
	
	
	//since we mappped agent_commision with customer_policy we dont need these 
		//customer_id and policy_id , keep only if you want for clear understanding 
		//else not
	
	//not using objects of policy and customer since, we can find the objects from these
	//fields however, so no need
	
	@ManyToOne	
	@JoinColumn(name="policy_id")
	private Policy policy;
	
	
	
	@ManyToOne
	@JoinColumn(name="customer_id")
	private Customer customer;
	
	
	@ManyToOne
	@JoinColumn(name="agent_id")
	private Agent agent;
	


	//use premium_cost from customer_policy to calculate agent's commission
	@Column(name="premium_commission")
	private float premium_commission;

	@Column(name="amount_received")
	private int amount_received;

	
	
	
	
	
	//using customer_policy object you can retrieve the respective that object's 
	//customer_id also so don't create extra field
		
	//getters and setters
		


	public int getAgent_commission_id() {
		return agent_commission_id;
	}




	public void setAgent_commission_id(int agent_commission_id) {
		this.agent_commission_id = agent_commission_id;
	}




	public Customer_Policy getCustomer_policy() {
		return customer_policy;
	}




	public void setCustomer_policy(Customer_Policy customer_policy) {
		this.customer_policy = customer_policy;
	}




	public Policy getPolicy() {
		return policy;
	}




	public void setPolicy(Policy policy) {
		this.policy = policy;
	}




	public Customer getCustomer() {
		return customer;
	}




	public void setCustomer(Customer customer) {
		this.customer = customer;
	}




	public Agent getAgent() {
		return agent;
	}




	public void setAgent(Agent agent) {
		this.agent = agent;
	}




	public float getPremium_commission() {
		return premium_commission;
	}




	public void setPremium_commission(float premium_commission) {
		this.premium_commission = premium_commission;
	}




	public int getAmount_received() {
		return amount_received;
	}




	public void setAmount_received(int amount_received) {
		this.amount_received = amount_received;
	}

	public Agent_Commission() {}


	//constructors

	public Agent_Commission(Policy policy, Customer customer, Agent agent) {
		super();
		this.policy = policy;
		this.customer = customer;
		this.agent = agent;
		this.premium_commission = (float) (0.15 * policy.getPremium_cost()* 12);
		this.amount_received = 0;

	}





	@Override
	public String toString() {
		return "Agent_Commission [agent_commission_id=" + agent_commission_id + ", customer_policy=" + customer_policy
				+ ", policy=" + policy + ", customer=" + customer + ", agent=" + agent + ", premium_commission="
				+ premium_commission + ", amount_received=" + amount_received + "]";
	}






	


	
}

	
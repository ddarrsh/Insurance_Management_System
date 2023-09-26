package com.example.demo;
import java.time.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.boot.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demo.entities.Address;
import com.example.demo.entities.Agent;
import com.example.demo.entities.Customer;
import com.example.demo.entities.Customer_Policy;
import com.example.demo.entities.Policy;
import com.example.demo.entities.PolicyDetails;
import com.example.demo.repository.AgentRepo;
import com.example.demo.repository.CustomerPolicyRepo;
import com.example.demo.repository.CustomerRepo;
import com.example.demo.repository.PolicyRepo;

import jakarta.transaction.Transactional;

@SuppressWarnings("unused")
@SpringBootApplication
public class InsuranceMangamentApplication {

	public static void main(String[] args) {
		SpringApplication.run(InsuranceMangamentApplication.class, args);
	}
	@Bean
	public CommandLineRunner commandLineRunner(CustomerPolicyRepo customerPolicyRepo,CustomerRepo customerRepo,PolicyRepo policyRepo,AgentRepo agentRepo)
	{		return runner -> {
			
			addCustomer(customerRepo);
			addPolicy(policyRepo);
//			 below is pending 
			addAgent(agentRepo);
			addcustomerPolicy(customerPolicyRepo,customerRepo,policyRepo,agentRepo);
	};
	}


	

	private void addCustomer(CustomerRepo customerRepo)
	{
		Customer c1=new Customer("Darsh","Jain","darshbagrecha@gmail.com");
		Address a1=new Address("Near Kidzee School","Lingad Road","Bijapur","Bijapur",586101,"karnataka","India");
		c1.setAddress(a1);
		customerRepo.save(c1);
	
	
		Customer c2=new Customer("Rakshit","Gobbi","rakshitsubhasgobbi@gmail.com");
		Address a2=new Address("Bldea engineering College ","Boys Hostel","Bijapur","Bijapur",586101,"karnataka","India");
		c2.setAddress(a2);
		customerRepo.save(c2);
	}

	@Transactional
	private void addPolicy(PolicyRepo policyRepo)
	{
		Policy p1=new Policy("Pradhan mantri Yojna","Heart Related Conditions",599,(float) 4.5,3,70);
		int maturity_amount=(int)(p1.getSum_assured()+ 0.02 * p1.getSum_assured());
		PolicyDetails pd=new PolicyDetails(10000,"Medicines/Drugs","70% of all the medicines, and suregery required amineties will be reimbursed",maturity_amount);
		p1.setPolicyDetails(pd);
		policyRepo.save(p1);
		
		Policy p2=new Policy("PM Murmu SC-ST Vikas ","Neurological Treatment",700,(float) 3.0,1,45);
		maturity_amount=(int)(p2.getSum_assured()+ 0.02 * p2.getSum_assured());
		PolicyDetails pd2=new PolicyDetails(10001,"Insulin and other amenietes","45% of all the medicines, and suregery required amineties will be reimbursed",maturity_amount);
		p2.setPolicyDetails(pd2);
		policyRepo.save(p2);
		
		Policy p3=new Policy("Preventive Care Policy","brain injury care policy",1200,(float) 4.8,4,50);
		maturity_amount=(int)(p3.getSum_assured()+ 0.02 * p3.getSum_assured());
		PolicyDetails pd3=new PolicyDetails(10002,"hospitalization, surgery, and other medical treatments related to the TBI.","50% of all the medicines, and suregery required amineties will be reimbursed",maturity_amount);
		p3.setPolicyDetails(pd3);
		policyRepo.save(p3);
	}
	
	
	
	private void addAgent(AgentRepo agentRepo) {
	Agent a=new Agent("Mukund","Reddy","reddy424@gmail.com");
	Address ad=new Address("Near Shantiniketan ","Makonda Poda","Mysore","Old Mysore",512311,"karnataka","India");
	a.setAddress(ad);
	agentRepo.save(a);
	
	Agent a2=new Agent("Hamid","Shaikh","shaikhhamid11@gmail.com");
	Address ad2=new Address("malakpet","Tarnaka","Hyderabad","Hydederabd",132311,"Andra Pradesh","India");
	a2.setAddress(ad2);
	agentRepo.save(a2);
	}
	
	
	
	
	
	
	
	
	private void addcustomerPolicy(CustomerPolicyRepo customerPolicyRepo,CustomerRepo customerRepo,PolicyRepo policyRepo,AgentRepo agentRepo) {
		//id1
		
		
//		List<Policy> policies=new ArrayList<>();
//		
		Customer c=customerRepo.findById(1).get();
		Policy p=policyRepo.findById(1).get();
		Agent  a=agentRepo.findById(1).get();
		Customer_Policy customerpolicy=new Customer_Policy(c,p, LocalDate.now(),a);
		customerPolicyRepo.save(customerpolicy);
		//c.addCustomerPolicy(customerpolicy);
		
	
		
		//id2
		Customer c2=customerRepo.findById(2).get();
		Policy p2=policyRepo.findById(1).get();
		Agent  a2=agentRepo.findById(2).get();
		Customer_Policy customerpolicy2=new Customer_Policy(c2,p2,LocalDate.now(),a2);
		customerPolicyRepo.save(customerpolicy2);
//		c2.addCustomerPolicy(customerpolicy2);
//		policies.add(p2);    
		
		
		//id2
		Customer c3=customerRepo.findById(2).get();
		Policy p3=policyRepo.findById(2).get();
		Agent  a3=agentRepo.findById(2).get();
		Customer_Policy customerpolicy3=new Customer_Policy(c3,p3, LocalDate.now(),a3);
		customerPolicyRepo.save(customerpolicy3);
//		c3.addCustomerPolicy(customerpolicy3);
//		policies.add(p3);    
		
		//id2
		Customer c4=customerRepo.findById(2).get();
		Policy p4=policyRepo.findById(3).get();
		Agent  a4=agentRepo.findById(1).get();
		Customer_Policy customerpolicy4=new Customer_Policy(c4,p4, LocalDate.now(),a4);
		customerPolicyRepo.save(customerpolicy4);
		
		
		
		
		//fetching policy list
		Customer q=customerRepo.findById(2).get();
		System.out.println("List of Policies of Customer with id 2:");
//		List<Policy> policies2=new ArrayList<>(); 
		for(Customer_Policy po: q.getCustomer_policy_list()) {
			System.out.println(po.getE().getPolicy().getPolicy_name());
		}
		
		//fetching customer list
		
		Policy m=policyRepo.findById(3).get();
		System.out.println("List of Customers of Policy with id 2:");
		for(Customer_Policy po: m.getCustomer_policy_list()) {
			System.out.println(po.getE().getCustomer().getFirst_name()+" "+po.getE().getCustomer().getLast_name());
		}
		
		
		Customer t=customerRepo.findById(1).get();
		System.out.println("List of Policies of Customer with id 1:");
//		List<Policy> policies2=new ArrayList<>(); 
		for(Customer_Policy po: t.getCustomer_policy_list()) {
			System.out.println(po.getE().getPolicy().getPolicy_name());
		}
		
		
		
		Policy u=policyRepo.findById(1).get();
		System.out.println("List of Customers of Policy with id 2:");
		for(Customer_Policy po: u.getCustomer_policy_list()) {
			System.out.println(po.getE().getCustomer().getFirst_name()+" "+po.getE().getCustomer().getLast_name());
		}

		
		
	} 

}

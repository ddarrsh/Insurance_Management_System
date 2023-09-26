package com.example.demo.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Customer_Policy;
import com.example.demo.entities.Embedded;

public interface CustomerPolicyRepo extends JpaRepository<Customer_Policy,Embedded>  {

}

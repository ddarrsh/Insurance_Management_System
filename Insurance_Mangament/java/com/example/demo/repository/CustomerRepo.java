package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Customer;

public interface CustomerRepo extends JpaRepository<Customer,Integer>{

}

package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Address;
public interface AddressRepo extends JpaRepository<Address,Integer> {

}

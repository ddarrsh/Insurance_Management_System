package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.PolicyDetails;

public interface PolicyDetailsRepo extends JpaRepository<PolicyDetails,Integer> {

}

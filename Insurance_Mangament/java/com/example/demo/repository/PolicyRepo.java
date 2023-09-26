package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Policy;

public interface PolicyRepo extends JpaRepository<Policy,Integer> {

}

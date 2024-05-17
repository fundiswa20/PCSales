package com.example.pcsale.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.pcsale.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long>{

}

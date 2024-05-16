package com.example.pcsale.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.pcsale.model.Laptop;

@Repository
public interface LapTopRepository extends JpaRepository<Laptop, Long> {

}

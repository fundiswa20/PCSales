package com.example.pcsale.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.pcsale.model.Cart;

public interface CartRepository extends JpaRepository<Cart,Long> {

}

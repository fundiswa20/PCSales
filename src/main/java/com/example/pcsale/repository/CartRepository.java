package com.example.pcsale.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.pcsale.model.Cart;

public interface CartRepository extends JpaRepository<Cart,Long> {

}

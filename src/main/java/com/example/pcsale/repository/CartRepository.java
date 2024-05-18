package com.example.pcsale.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.pcsale.model.Cart;

public interface CartRepository extends JpaRepository<Cart,Long> {
  //  List<Cart> findByUserId(Long userId);
}

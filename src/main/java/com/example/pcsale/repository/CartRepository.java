package com.example.pcsale.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.pcsale.model.Cart;

public interface CartRepository extends JpaRepository<Cart,Long> {

    @Query
    Optional<Cart> findByUserId(Long userId);
}

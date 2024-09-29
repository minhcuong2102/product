package com.example.product_filter.repository;

import com.example.product_filter.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICartRepository extends JpaRepository<Cart, Integer> {
    Cart findById(int id);
}

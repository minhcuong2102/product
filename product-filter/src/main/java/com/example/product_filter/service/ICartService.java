package com.example.product_filter.service;

import com.example.product_filter.model.Product;

public interface ICartService {
    void addToCart(Product product, int quantity);
}

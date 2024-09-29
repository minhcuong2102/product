package com.example.product_filter.service;

import com.example.product_filter.model.Product;

public interface IOrderService {
    void buyProductsNow(Product product, int quantity);
}

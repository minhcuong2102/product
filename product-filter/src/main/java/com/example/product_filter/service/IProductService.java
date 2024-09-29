package com.example.product_filter.service;

import com.example.product_filter.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> searchProducts(String name, String category, Double minPrice,
                                 Double maxPrice, String size, String style, String color);

    Product getProductById(int id);
}

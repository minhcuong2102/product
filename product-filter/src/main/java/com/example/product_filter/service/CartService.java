package com.example.product_filter.service;

import com.example.product_filter.model.Cart;
import com.example.product_filter.model.Product;
import com.example.product_filter.repository.ICartRepository;
import com.example.product_filter.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartService implements ICartService {
    @Autowired
    private ICartRepository cartRepository;

    @Autowired
    private IProductRepository productRepository;

    @Override
    public void addToCart(Product product, int quantity) {
        Cart cart = new Cart();
        if (quantity <= 0) {
            throw new IllegalArgumentException("Số lượng sản phẩm không hợp lệ!");
        }

//        for (int i = 0; i < quantity; i++) {
//            cart.getProducts().add(product);
//        }
        cart.getProducts().add(product);
        cart.setQuantity(quantity);
        cartRepository.save(cart);
    }
}

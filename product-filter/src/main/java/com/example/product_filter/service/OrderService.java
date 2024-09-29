package com.example.product_filter.service;

import com.example.product_filter.model.Order;
import com.example.product_filter.model.Product;
import com.example.product_filter.repository.IOrderRepository;
import com.example.product_filter.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService implements IOrderService{
    @Autowired
    IOrderRepository orderRepository;
    @Autowired
    private IProductRepository productRepository;
    public void buyProductsNow(Product product, int quantity) {
        Order order = new Order();
        if (quantity <= 0) {
            throw new IllegalArgumentException("Số lượng sản phẩm không hợp lệ");
        }

//        for (int i = 0; i < quantity; i++) {
//            order.getProducts().add(product);
//        }
        order.getProducts().add(product);
        order.setQuantity(quantity);
        orderRepository.save(order);
    }
}

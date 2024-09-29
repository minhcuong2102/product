package com.example.product_filter.controller;

import com.example.product_filter.model.Product;
import com.example.product_filter.service.ICartService;
import com.example.product_filter.service.ICategoryService;
import com.example.product_filter.service.IOrderService;
import com.example.product_filter.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    @Autowired
    ICategoryService iCategoryService;
    @Autowired
    IProductService iProductService;
    @Autowired
    private ICartService iCartService;
    @Autowired
    private IOrderService iOrderService;

    @GetMapping("/filter")
    public List<Product> searchProducts(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String category,
            @RequestParam(required = false) Double minPrice,
            @RequestParam(required = false) Double maxPrice,
            @RequestParam(required = false) String size,
            @RequestParam(required = false) String style,
            @RequestParam(required = false) String color) {
        return iProductService.searchProducts(name, category, minPrice, maxPrice, size, style, color);
    }

    @GetMapping("")
    public Product productDetail(
            @RequestParam int id) {
        return iProductService.getProductById(id);
    }

    @PostMapping("/cart")
    public void addToCart(@RequestParam String productName,
                          @RequestParam String color,
                          @RequestParam String size,
                          @RequestParam String style,
                          @RequestParam int quantity) {
        Product product = iProductService.searchProducts(productName, null, null, null, size, style, color).get(0);
        iCartService.addToCart(product, quantity);
    }

    @PostMapping("/buy")
    public void buyProducts(@RequestParam String productName,
                            @RequestParam String color,
                            @RequestParam String size,
                            @RequestParam String style,
                            @RequestParam int quantity) {
        Product product = iProductService.searchProducts(productName, null, null, null, size, style, color).get(0);
        iOrderService.buyProductsNow(product, quantity);
    }
}

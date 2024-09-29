package com.example.product_filter.service;

import com.example.product_filter.model.Category;
import com.example.product_filter.model.Product;
import com.example.product_filter.model.dto.CategoryDTO;
import com.example.product_filter.model.dto.ProductDTO;
import com.example.product_filter.repository.ICategoryRepository;
import com.example.product_filter.repository.IOrderRepository;
import com.example.product_filter.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService implements IProductService {
    @Autowired
    IProductRepository productRepository;
    @Autowired
    ICategoryRepository categoryRepository;
    @Autowired
    IOrderRepository orderRepository;

    @Override
    public Product getProductById(int id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public List<Product> searchProducts(String name, String category, Double minPrice,
                                        Double maxPrice, String size, String style, String color) {
        List<ProductDTO> productDTOs = productRepository.filterAllProduct();

        List<Product> productList = new ArrayList<>();
        for (ProductDTO productDTO : productDTOs) {
            Product product = new Product();
            product.setId(productDTO.getId());
            product.setName(productDTO.getName());
            product.setColor(productDTO.getColor());
            product.setPrice(productDTO.getPrice());
            product.setDescription(productDTO.getDescription());
            product.setSize(productDTO.getSize());
            product.setStyle(productDTO.getStyle());
            product.setAvatarURL(productDTO.getAvatarurl());
            List<CategoryDTO> categories = categoryRepository.findByName(productDTO.getCategoryName());
            Category category1 = new Category(categories.get(0).getId(), categories.get(0).getName());
            product.setCategory(category1);
            productList.add(product);
        }
        if (name == null && color == null && maxPrice == null && minPrice == null && category == null && size == null && style == null) {
            return productList;
        } else {
            List<Product> products = productList;

            if (name != null) {
                products = products.stream()
                        .filter(p -> p.getName().toLowerCase().contains(name.toLowerCase()))
                        .collect(Collectors.toList());
            }
            if (category != null) {
//                products = productRepository.findByCategory_NameContainingIgnoreCase(category);
                products = products.stream()
                        .filter(p -> p.getCategory().getName().toLowerCase().contains(category.toLowerCase()))
                        .collect(Collectors.toList());
            }
            if (minPrice != null && maxPrice != null) {
                products = products.stream()
                        .filter(p -> p.getPrice() >= minPrice && p.getPrice() <= maxPrice)
                        .collect(Collectors.toList());
            }
            if (size != null) {
                products = products.stream()
                        .filter(p -> p.getSize().toLowerCase().contains(size.toLowerCase()))
                        .collect(Collectors.toList());
            }
            if (style != null) {
                products = products.stream()
                        .filter(p -> p.getStyle().toLowerCase().contains(style.toLowerCase()))
                        .collect(Collectors.toList());
            }
            if (color != null) {
                products = products.stream()
                        .filter(p -> p.getColor().toLowerCase().contains(color.toLowerCase()))
                        .collect(Collectors.toList());
            }

            return products;
        }
    }
}

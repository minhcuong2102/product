package com.example.product_filter.repository;

import com.example.product_filter.model.Product;
import com.example.product_filter.model.dto.ProductDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IProductRepository extends JpaRepository<Product, Integer> {
    List<Product> findByCategory_NameContainingIgnoreCase(String categoryName);

    List<Product> findByNameContainingIgnoreCase(String name);

    List<Product> findByPriceBetween(double minPrice, double maxPrice);

    List<Product> findBySizeContainingIgnoreCase(String size);

    List<Product> findByStyleContainingIgnoreCase(String style);

    List<Product> findByColorContainingIgnoreCase(String color);

    @Modifying
    @Query(value = "select p.id, p.name, p.color, p.price, p.description, p.size, p.style, p.avatarurl, c.name as categoryname from product p join category c on p.category_id = c.id order by p.id", nativeQuery = true)
//    @Query(value = "select * from `product`", nativeQuery = true)
    List<ProductDTO> filterAllProduct();
}

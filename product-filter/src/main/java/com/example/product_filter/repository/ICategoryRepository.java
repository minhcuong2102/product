package com.example.product_filter.repository;

import com.example.product_filter.model.Category;
import com.example.product_filter.model.dto.CategoryDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICategoryRepository extends JpaRepository<Category, Integer> {
    @Modifying
    @Query(value = "select * from category where name = ?1", nativeQuery = true)
    List<CategoryDTO> findByName(String name);
}

package com.example.product_filter.service;

import com.example.product_filter.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICategoryService {
    List<Category> findAll();

    void save(Category category);

    Category findById(int id);

    void remove(int id);

    List<Category> findByName(String nameSearch);

    Page<Category> search(String nameSearch, Pageable pageable);
}

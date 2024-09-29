package com.example.product_filter.service;

import com.example.product_filter.model.Category;
import com.example.product_filter.repository.ICategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService implements ICategoryService{
    @Autowired
    ICategoryRepository iCategoryRepository;

    @Override
    public List<Category> findAll() {
        return iCategoryRepository.findAll();
    }

    @Override
    public void save(Category category) {
        iCategoryRepository.save(category);
    }

    @Override
    public Category findById(int id) {
        return iCategoryRepository.findById(id).orElse(null);
    }

    @Override
    public void remove(int id) {
        iCategoryRepository.deleteById(id);
    }

    @Override
    public List<Category> findByName(String nameSearch) {
        return null;
    }

    @Override
    public Page<Category> search(String nameSearch, Pageable pageable) {
        return null;
    }
}

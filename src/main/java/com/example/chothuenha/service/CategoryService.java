package com.example.chothuenha.service;

import com.example.chothuenha.model.Category;

public interface CategoryService {
    Iterable<Category> findAll();
    Category findById(Long id);
    void delete(Long id);
    void save(Category category);
    Category findByName(String name);
}

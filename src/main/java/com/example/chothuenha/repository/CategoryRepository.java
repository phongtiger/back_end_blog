package com.example.chothuenha.repository;

import com.example.chothuenha.model.Category;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends PagingAndSortingRepository<Category,Long> {
    Category findByName(String name);
}

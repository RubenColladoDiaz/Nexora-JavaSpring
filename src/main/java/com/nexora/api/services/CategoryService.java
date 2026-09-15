package com.nexora.api.services;

import com.nexora.api.entities.Category;
import com.nexora.api.repositories.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> findAll(){
        return categoryRepository.findAll();
    }

    public Optional<Category> findById(Long id){
        return categoryRepository.findById(id);
    }

    public Category save(Category product){
        return categoryRepository.save(product);
    }

    public void delete(Long id){
        categoryRepository.deleteById(id);
    }
}

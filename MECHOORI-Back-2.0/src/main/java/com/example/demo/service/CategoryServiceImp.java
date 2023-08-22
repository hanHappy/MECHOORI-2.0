package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.Category;
import com.example.demo.repository.CategoryRepository;

@Service
public class CategoryServiceImp implements CategoryService{

    @Autowired
    private CategoryRepository repository;

    @Override
    public List<Category> getList() {
        return repository.findAll();
    }

    @Override
    public Category getById(int id) {
        return repository.findById(id);
    }

    @Override
    public Category update(Category category) {
        int result = repository.update(category);
        if(result == 1)
            return repository.findById(category.getId());
        return null;
    }
    
    @Override
    public Category add(Category category) {
        // db에 추가
        repository.add(category);

        Category newCategory = repository.findByName(category.getName());
        
        return newCategory;
    }

    @Override
    @Transactional
    public Category delete(int id) {
        Category category = repository.findById(id);
        if(category == null)
            return null;
        
        repository.delete(id);
        
        repository.addDeleteHistory(category);

        Category deletedCategory = repository.findDeletedCategoryById(id);

        return deletedCategory;
    }
    
}

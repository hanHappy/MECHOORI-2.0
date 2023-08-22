package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Category;

public interface CategoryService {

	List<Category> getList();

    Category getById(int id);

    Category update(Category category);

    Category add(Category category);

    Category delete(int id);

}

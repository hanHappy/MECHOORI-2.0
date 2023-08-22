package com.example.demo.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.entity.Category;

@Mapper
public interface CategoryRepository {

    List<Category> findAll();

    Category findById(int id);

    int update(Category category);

	void add(Category category);

    Category findByName(String name);

    int delete(int id);

    void addDeleteHistory(Category category);

    Category findDeletedCategoryById(int id);

}

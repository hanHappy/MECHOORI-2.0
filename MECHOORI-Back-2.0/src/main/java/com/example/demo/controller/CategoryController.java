package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Category;
import com.example.demo.exception.Exc;
import com.example.demo.service.CategoryService;

@RestController
@RequestMapping("api/category")
public class CategoryController {
    @Autowired
    private CategoryService service;

    @GetMapping("list")
    public ResponseEntity<List<Category>> list(){

        List<Category> list = service.getList();

        return Exc.handleException(list);
    }

    @GetMapping("{id}")
    public ResponseEntity<Category> detail(@PathVariable("id") int id){
        Category category = service.getById(id);
        return Exc.handleException(category);
    }

    @PutMapping("edit")
    public ResponseEntity<Category> update(@RequestBody Category category){

        Category updatedCategory = service.update(category);

        return Exc.handleException(updatedCategory);
    }

    @PostMapping("add")
    public ResponseEntity<Category> add(@RequestBody Category category){
        Category newCategory = service.add(category);
        return Exc.handleException(newCategory);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Category> delete(@PathVariable("id") int id){
        Category deletedCategory = service.delete(id);
        return Exc.handleException(deletedCategory);
    }

}
package com.example.demo.controller;

import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Menu;
import com.example.demo.exception.Exc;
import com.example.demo.service.MenuService;

@RestController
@RequestMapping("api/menu")
public class MenuController{
    @Autowired
    private MenuService service;

    @GetMapping("{id}")
    public ResponseEntity<Object> detail(@PathVariable("id") int id){

        Menu menu = service.getById(id);

        return Exc.handleException(menu);
    }

    @PutMapping("{id}")
    public ResponseEntity<Object> update(@RequestBody Menu menu){
        Menu newMenu = service.update(menu);
        
        return Exc.handleException(newMenu);
    }
    
    @PostMapping("add")
    public ResponseEntity<Object> add(@RequestBody Menu menu){
        Menu newMenu = service.add(menu);
        
        return Exc.handleException(newMenu);
    }

    @DeleteMapping("{id}")
    public int delete(@PathVariable("id") int id){
        return service.delete(id);
    }

}
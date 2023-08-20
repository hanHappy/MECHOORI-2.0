package com.example.demo.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.entity.Menu;

@Mapper
public interface MenuRepository {

    List<Menu> findAll(int restaurantId);

    Menu findById(int id);

    void update(Menu menu);

    int add(Menu menu);

    Menu findLatest();

    int delete(int id);

}

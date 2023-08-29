package com.example.demo.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.entity.Restaurant;

@Mapper
public interface RestaurantRepository {

    List<Restaurant> findAll(String name, Integer categoryId, String filter);

    Restaurant findById(int id);

    int update(Restaurant restaurant);

    void add(Restaurant restaurant);

    Restaurant findByName(String name);

}

package com.example.demo.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.entity.Restaurant;

@Mapper
public interface RestaurantRepository {

    List<Restaurant> findAll(String query);

    Restaurant find(int id);

    int update(Restaurant restaurant);

	int add(Restaurant restaurant);

    int delete(int id);

}

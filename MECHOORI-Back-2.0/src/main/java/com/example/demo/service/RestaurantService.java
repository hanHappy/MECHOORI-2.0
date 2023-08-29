package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Restaurant;

public interface RestaurantService {

    List<Restaurant> getList();

    List<Restaurant> getListByName(String name);

    List<Restaurant> getListByCategoryId(Integer categoryId);

    List<Restaurant> getListByFilterId(Integer filterId);

    Restaurant getById(int id);

    Restaurant update(Restaurant restaurant);

	Restaurant add(Restaurant restaurant);

}

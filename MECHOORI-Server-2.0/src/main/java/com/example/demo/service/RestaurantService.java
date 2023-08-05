package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Restaurant;

public interface RestaurantService {

	List<Restaurant> getList();
	List<Restaurant> getListByQuery(String query);
    Restaurant get(int id);
	int update(Restaurant restaurant);

}

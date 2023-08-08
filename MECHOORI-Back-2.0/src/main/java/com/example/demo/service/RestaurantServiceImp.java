package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Restaurant;
import com.example.demo.repository.RestaurantRepository;

@Service
public class RestaurantServiceImp implements RestaurantService{

    @Autowired
    private RestaurantRepository repository;

    @Override
    public List<Restaurant> getList() {
        return repository.findAll(null);
    }

    @Override
    public List<Restaurant> getListByQuery(String query) {
        return repository.findAll(query);
    }

    @Override
    public Restaurant get(int id) {
        return repository.find(id);
    }

    @Override
    public int update(Restaurant restaurant) {
        return repository.update(restaurant);
    }

    @Override
    public int add(Restaurant restaurant) {
        return repository.add(restaurant);
    }

    @Override
    public int delete(int id) {
        return repository.delete(id);
    }
    
}

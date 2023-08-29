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
        return repository.findAll(null, null, null);
    }

    @Override
    public List<Restaurant> getListByName(String name) {
        return repository.findAll(name, null, null);
    }

    @Override
    public List<Restaurant> getListByCategoryId(Integer categoryId) {
        return repository.findAll(null, categoryId, null);
    }

    @Override
    public List<Restaurant> getListByFilterId(Integer filterId) {
        
        String filter = "";

        switch(filterId){
            case 1:
                filter = "value desc";
                break;
            case 2:
                filter = "avg_price";
                break;
            case 3:
                filter = "avg_price desc";
                break;
            case 4:
                filter = "like_count desc";
                break;
            case 5:
                filter = "rate_count desc";
                break;
        }

        return repository.findAll(null, null, filter);
    }

    @Override
    public Restaurant getById(int id) {
        return repository.findById(id);
    }

    @Override
    public Restaurant update(Restaurant restaurant) {
        int result = repository.update(restaurant);
        if(result == 1)
            return repository.findById(restaurant.getId());
        else
            return null;
    }

    @Override
    public Restaurant add(Restaurant restaurant) {
        repository.add(restaurant);
        Restaurant addedRestaurant = repository.findByName(restaurant.getName());
        return addedRestaurant;
    }
    
}

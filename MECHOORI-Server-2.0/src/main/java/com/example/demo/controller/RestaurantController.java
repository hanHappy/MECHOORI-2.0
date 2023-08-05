package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Restaurant;
import com.example.demo.service.RestaurantService;

@RestController
@RequestMapping("restaurant")
public class RestaurantController {
    
    @Autowired
    private RestaurantService service;

    @GetMapping("list") // restaurant/list?q=짜장
    public List<Restaurant> list(
        @RequestParam(name = "q ", required = false) String query){

        List<Restaurant> list = null;

        if(query == null)
            list = service.getList();
        else
            list = service.getListByQuery(query);

        return list;
    }

    @GetMapping("{id}")  // restaurant/160
    public Restaurant detail(@PathVariable("id") int id){
        return service.get(id);
    }

    @PutMapping("edit")
    public int update(@RequestBody Restaurant restaurant){
        return service.update(restaurant);
    }

}

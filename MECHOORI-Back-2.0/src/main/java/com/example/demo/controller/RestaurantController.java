package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Menu;
import com.example.demo.entity.Restaurant;
import com.example.demo.service.MenuService;
import com.example.demo.service.RestaurantService;

@RestController
@RequestMapping("restaurant")
public class RestaurantController {
    
    @Autowired
    private RestaurantService service;

    @Autowired
    private MenuService menuService;

    @GetMapping("list") // restaurant/list?q=짜장
    public List<Restaurant> list(
        @RequestParam(name = "q", required = false) String query){

        List<Restaurant> list = null;

        if(query == null)
            list = service.getList();
        else
            list = service.getListByQuery(query);

        return list;
    }

    @GetMapping("{id}")
    public Restaurant detail(@PathVariable("id") int id){
        return service.get(id);
    }

    @PutMapping("edit")
    public int update(@RequestBody Restaurant restaurant){
        return service.update(restaurant);
    }

    @PostMapping("add")
    public int add(@RequestBody Restaurant restaurant){
        return service.add(restaurant);
    }

    @DeleteMapping("{id}")
    public int delete(@PathVariable("id") int id){
        return service.delete(id);
    }

    @GetMapping("{id}/menu")
    public ResponseEntity<Object> menuList(@PathVariable("id") int restaurantId){

        List<Menu> list = menuService.getList(restaurantId);

        if(list.size()==0)
            return new ResponseEntity<Object>("오류", HttpStatus.BAD_REQUEST);

        return new ResponseEntity<Object>(list, HttpStatus.OK);
    }

}

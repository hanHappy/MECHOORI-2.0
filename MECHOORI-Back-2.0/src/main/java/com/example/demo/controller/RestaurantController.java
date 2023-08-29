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
import com.example.demo.exception.Exc;
import com.example.demo.service.MenuService;
import com.example.demo.service.RestaurantService;

@RestController
@RequestMapping("restaurant")
public class RestaurantController {
    
    @Autowired
    private RestaurantService service;

    @Autowired
    private MenuService menuService;

    // http://localhost:8080/restrant/list?q=짜장
    @GetMapping("list")
    public ResponseEntity<List<Restaurant>> list(
        @RequestParam(name = "q", required = false) String name,
        @RequestParam(name = "c", required = false) Integer categoryId,
        @RequestParam(name = "f", required = false) Integer filterId){

        List<Restaurant> list = null;

        if(name != null)
            list = service.getListByName(name);
        else if(categoryId != null)
            list = service.getListByCategoryId(categoryId);
        else if(filterId != null)
            list = service.getListByFilterId(filterId);
        else 
            list = service.getList();
        
        return Exc.handleException(list);
    }

    @GetMapping("{id}")
    public ResponseEntity<Restaurant> detail(@PathVariable("id") int id){
        Restaurant restaurant = service.getById(id);
        return Exc.handleException(restaurant);
    }

    @PostMapping("add")
    public ResponseEntity<Restaurant> add(@RequestBody Restaurant restaurant){
        Restaurant addedRestaurant = service.add(restaurant);
        return Exc.handleException(addedRestaurant);
    }

    @PutMapping("edit")
    public ResponseEntity<Restaurant> edit(@RequestBody Restaurant restaurant){
        Restaurant updatedRestaurant = service.update(restaurant);
        return Exc.handleException(updatedRestaurant);
    }

    @GetMapping("{id}/menu")
    public ResponseEntity<Object> menuList(@PathVariable("id") int restaurantId){

        List<Menu> list = menuService.getList(restaurantId);

        if(list.size()==0)
            return new ResponseEntity<Object>("오류", HttpStatus.BAD_REQUEST);

        return new ResponseEntity<Object>(list, HttpStatus.OK);
    }

}

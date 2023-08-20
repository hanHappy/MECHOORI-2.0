package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Menu;

public interface MenuService {

    List<Menu> getList(int restaurantId);

    Menu getById(int id);

	Menu update(Menu menu);

    Menu add(Menu menu);

    int delete(int id);

}

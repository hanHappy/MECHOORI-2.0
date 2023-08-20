package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Menu;
import com.example.demo.repository.MenuRepository;

@Service
public class MenuServiceImp implements MenuService{

    @Autowired
    private MenuRepository repository;

    @Override
    public List<Menu> getList(int restaurantId) {
        return repository.findAll(restaurantId);
    }

    @Override
    public Menu getById(int id) {
        return repository.findById(id);
    }

    @Override
    public Menu update(Menu menu) {
        repository.update(menu);
        Menu newMenu = repository.findById(menu.getId());
        return newMenu;
    }
    
    @Override
    public Menu add(Menu menu) {
        int result = repository.add(menu);

        if(result == 0)
            return null;
            
        Menu newMenu = repository.findLatest();
            
        return newMenu;
    }

    @Override
    public int delete(int id) {
        return repository.delete(id);
    }
    
}

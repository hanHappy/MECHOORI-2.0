package com.example.demo.entity;

import lombok.Data;

@Data
public class Menu {
    private int id;
    private int restaurantId;
    private String name;
    private Integer price;
}
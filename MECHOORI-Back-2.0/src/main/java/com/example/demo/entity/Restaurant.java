package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Restaurant {
    private int id;
    private int categoryId;
    private String name;
    private String img;
    private String intro;
    private String address;
    private String operatingTime;
    private String contactNumber;
}
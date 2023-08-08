package com.example.demo.entity;

import lombok.Data;

@Data
public class Restaurant {
    private Integer id;
	private Integer categoryId;
	private String name;
	private String img;
	private String intro;
	private String address;
	private String operatingTime;
	private String contactNumber;
}

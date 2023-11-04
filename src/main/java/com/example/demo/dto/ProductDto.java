package com.example.demo.dto;

import com.example.demo.model.Brand;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ProductDto {

	
	private String name;
	private String type;
	private Brand brand;

}

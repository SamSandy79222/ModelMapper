package com.example.demo.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.dto.BrandDto;
import com.example.demo.model.Brand;

@Component
public class BrandMapper {

	@Autowired
	Mapper mapper;
	
	public Brand toEntity(BrandDto  brandDto) {
		return mapper.modelMapper().map(brandDto, Brand.class);
	}
	
	public BrandDto toDto(Brand brand) {
		return mapper.modelMapper().map(brand, BrandDto.class);
	}
}

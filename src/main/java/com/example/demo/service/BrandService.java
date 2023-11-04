package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.dto.BrandDto;
import com.example.demo.model.Brand;

public interface BrandService {

	public BrandDto createBrand(BrandDto  brandDto);
	public List<BrandDto> getAllBrand();
	Optional<BrandDto> getById(long id);
	public BrandDto update(long id,BrandDto brandDto);
	
	
}

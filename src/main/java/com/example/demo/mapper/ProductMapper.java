package com.example.demo.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import com.example.demo.dto.ProductDto;
import com.example.demo.model.Product;

@Component
@Configuration
public class ProductMapper {

	@Autowired
	Mapper mapper;
	
	public Product toEntity(ProductDto dto) {
		return mapper.modelMapper().map(dto, Product.class);
	}
	
	public ProductDto toDto(Product product) {
		return mapper.modelMapper().map(product, ProductDto.class);
	}
}

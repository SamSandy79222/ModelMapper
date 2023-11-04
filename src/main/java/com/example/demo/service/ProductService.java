package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.dto.BrandDto;
import com.example.demo.dto.ProductDto;
import com.example.demo.model.Product;

public interface ProductService {

	public ProductDto saveProduct(ProductDto dto);
	public List<ProductDto> getAllProduct();
	public Optional<ProductDto> getProductById(long id);
	public ProductDto updateProduct(long id,ProductDto dto);
}

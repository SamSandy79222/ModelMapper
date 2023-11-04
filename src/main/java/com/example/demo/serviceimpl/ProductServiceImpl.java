package com.example.demo.serviceimpl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import com.example.demo.dto.BrandDto;
import com.example.demo.dto.ProductDto;
import com.example.demo.mapper.ProductMapper;
import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepository;
import com.example.demo.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{
@Autowired
ProductRepository productRepository;
	
@Autowired 
ModelMapper modelMapper;
	@Autowired
	ProductMapper productMapper;
	@Override
	public ProductDto saveProduct(ProductDto dto) {
		 Product product=productMapper.toEntity(dto);
		 Product savproduct=productRepository.save(product);
		return productMapper.toDto(savproduct);
	}
	@Override
	public List<ProductDto> getAllProduct() {
		  List<Product> product=productRepository.findAll();
		return product.stream().map(products->modelMapper.map(products, ProductDto.class)).collect(Collectors.toList());
	}
	@Override
	public Optional<ProductDto> getProductById(long id) {
		Optional<Product> product=productRepository.findById(id);
		
		return product.map(products->modelMapper.map(product, ProductDto.class));
	}
	
	@Override
	public ProductDto updateProduct(long id, ProductDto dto) {
		if (productRepository.findById(id).isPresent()) {
			Product product=productMapper.toEntity(dto);
			product.setId(id);
			Product saveproduct=productRepository.save(product);
			return productMapper.toDto(saveproduct);
		}
		return null;
	}
	

}

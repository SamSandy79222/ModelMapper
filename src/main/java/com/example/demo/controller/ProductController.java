package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.ProductDto;
import com.example.demo.model.Product;
import com.example.demo.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	ProductService productService;
	@PostMapping
	public ResponseEntity<ProductDto> saveProduct(@RequestBody ProductDto dto){
		ProductDto productDto=productService.saveProduct(dto);
		return new ResponseEntity<ProductDto>(productDto,HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<List<ProductDto>> getAllProduct(){
	List<ProductDto> dto=productService.getAllProduct();
	return new ResponseEntity<List<ProductDto>>(dto,HttpStatus.FOUND);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<ProductDto>> getById(@PathVariable long id){
		Optional<ProductDto> product=productService.getProductById(id);
		return new ResponseEntity<Optional<ProductDto>>(product,HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<ProductDto> updateProduct(@PathVariable long id,@RequestBody ProductDto productDto){
		ProductDto saveproduct=productService.updateProduct(id, productDto);
		return new ResponseEntity<ProductDto>(saveproduct,HttpStatus.ACCEPTED);
		
	}
	
}

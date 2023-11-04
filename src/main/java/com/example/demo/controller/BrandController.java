package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.BrandDto;
import com.example.demo.model.Brand;
import com.example.demo.service.BrandService;

@RestController
@RequestMapping("/brand")
public class BrandController {

	@Autowired
	BrandService brandService;
	@PostMapping
	public ResponseEntity<BrandDto> saveBrands(@RequestBody BrandDto brandDto){	
		return new ResponseEntity<>(brandService.createBrand(brandDto),HttpStatus.CREATED);
	}
	
	
	@GetMapping
	public ResponseEntity<List<BrandDto>> getAllBrand(){
	List<BrandDto> brands=brandService.getAllBrand();
	return new ResponseEntity<List<BrandDto>>(brands,HttpStatus.CREATED);
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<BrandDto>> getBrand(@PathVariable long id){
		Optional<BrandDto> brand=brandService.getById(id);
		return new ResponseEntity<Optional<BrandDto>>(brand,HttpStatus.FOUND);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<BrandDto> updateBrand(@PathVariable long id,@RequestBody BrandDto brandDto){
		BrandDto updateBrand=brandService.update(id, brandDto);
		return new ResponseEntity<BrandDto>(updateBrand,HttpStatus.ACCEPTED);
	}
	
	
}

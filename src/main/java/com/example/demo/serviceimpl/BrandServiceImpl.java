package com.example.demo.serviceimpl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import com.example.demo.dto.BrandDto;
import com.example.demo.mapper.BrandMapper;
import com.example.demo.model.Brand;
import com.example.demo.repository.BrandRepository;
import com.example.demo.service.BrandService;
@Service
public class BrandServiceImpl implements BrandService{
	
	@Autowired
	ModelMapper modelMapper;
	@Autowired
	BrandMapper brandMapper;
	@Autowired
	BrandRepository brandRepository;
	@Override
	public BrandDto createBrand(BrandDto brandDto) {
		Brand brand=brandMapper.toEntity(brandDto);
		brandRepository.save(brand);
		BrandDto dto=brandMapper.toDto(brand);
		return dto;
	}
	

	@Override
	public List<BrandDto> getAllBrand() {
		 List<Brand> brandss=brandRepository.findAll();
		 
		return brandss.stream().map(brands->modelMapper.map(brands, BrandDto.class)).collect(Collectors.toList());
	}

	@Override
	public Optional<BrandDto> getById(long id) {
		Optional<Brand> brand=brandRepository.findById(id);
		return brand.map(brands->modelMapper.map(brand, BrandDto.class));
		
	}


	@Override
	public BrandDto update(long id, BrandDto brandDto) {
		if (brandRepository.findById(id).isPresent()) {
			Brand brand=brandMapper.toEntity(brandDto);
			brand.setId(id);
			Brand saveBrand=brandRepository.save(brand);
			return brandMapper.toDto(saveBrand);
			
		}
return null;
	}

	

}

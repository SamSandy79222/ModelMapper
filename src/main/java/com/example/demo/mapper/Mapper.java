package com.example.demo.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.ui.ModelMap;

@Configuration
@Component
public class Mapper {

	@Bean
public ModelMapper modelMapper() {
	return new ModelMapper();
}
}

package com.example.demo.service;

import java.util.List;

import com.example.demo.payloads.CategoryDto;

public interface CategoryService
{

	//create
	CategoryDto createCategory(CategoryDto categoryDto);
	
	//update
	CategoryDto updateCategory(CategoryDto categorydto, Integer categoryId);
	
	//delete
	void deleteCategory (Integer categoryId);
	
	//get
	CategoryDto getCategory (Integer categoryId);
	
	//getall
	List<CategoryDto> getCategories();
}

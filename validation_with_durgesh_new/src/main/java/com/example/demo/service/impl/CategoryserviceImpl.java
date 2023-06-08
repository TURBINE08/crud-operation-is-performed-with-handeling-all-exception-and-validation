package com.example.demo.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import com.example.demo.entites.Category;
import com.example.demo.entites.Categoryy;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.payloads.CategoryDto;
import com.example.demo.repository.CategoryRepo;
import com.example.demo.service.CategoryService;
@Service
public class CategoryserviceImpl implements CategoryService
{
	@Autowired
	CategoryRepo categoryRepo;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public CategoryDto createCategory(CategoryDto categoryDto) 
	{
		
		
		Categoryy cat = this.modelMapper.map(categoryDto, Categoryy.class);
		
		Categoryy addedCat = this.categoryRepo.save(cat);
		
		return this.modelMapper.map(addedCat, CategoryDto.class);
	}

	@Override
	public CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId) {
 
		Categoryy cat = this.categoryRepo.findById(categoryId)
		.orElseThrow(()->new ResourceNotFoundException("Category", "Category", categoryId));
		 cat.setCategorytitle(categoryDto.getCategorytitle());
		 cat.setCategoryDescription(categoryDto.getCategoryDescription());
		
		 Categoryy updated = this.categoryRepo.save(cat);
		 
		return this.modelMapper.map(updated, CategoryDto.class);
	}

	@Override
	public void deleteCategory(Integer categoryId) 
	{
		Categoryy cat = categoryRepo.findById(categoryId)
		.orElseThrow(()->new ResourceNotFoundException("Category", "category id", categoryId));
		
		this.categoryRepo.delete(cat);
		
		// TODO Auto-generated method stub
		
	}

	@Override
	public CategoryDto getCategory(Integer categoryId) 
	{
		Categoryy cat = categoryRepo.findById(categoryId).orElseThrow(()->new ResourceNotFoundException("Category", "category id", categoryId));
		
		
		return this.modelMapper.map(cat, CategoryDto.class);
	}

	@Override
	public List<CategoryDto> getCategories() 
	{
		List<Categoryy>  category = this.categoryRepo.findAll();
		List<CategoryDto> catDtos = category.stream().map((cat)-> this.modelMapper.map(cat, CategoryDto.class)).collect(Collectors.toList());
		
		return catDtos;
	}

}

package com.yasir.blog.services;

import java.util.List;

import com.yasir.blog.payloads.CategoryDto;
import com.yasir.blog.payloads.UserDto;

public interface CategoryService {

	//create
	CategoryDto createCategory(CategoryDto user);
	
	//update
	CategoryDto updateCategory(CategoryDto user, Integer categoryId);
	
	//delete
	void deleteCategory(Integer categoryId);
	
	//get
	CategoryDto getCategory(Integer categoryId);
	
	//get All
	List<CategoryDto> getAllCategories();


}

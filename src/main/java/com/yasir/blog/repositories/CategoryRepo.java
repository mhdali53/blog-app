package com.yasir.blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yasir.blog.entities.Category;

public interface CategoryRepo extends JpaRepository<Category, Integer>{

}

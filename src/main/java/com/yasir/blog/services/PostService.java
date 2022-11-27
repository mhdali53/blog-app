package com.yasir.blog.services;

import java.util.List;

import com.yasir.blog.entities.Post;
import com.yasir.blog.payloads.PostDto;
import com.yasir.blog.payloads.PostResponse;

public interface PostService {

	
	//create
	PostDto createPost(PostDto postDto, Integer userId, Integer categoryId);
	
	//update
	PostDto updatePost(PostDto user, Integer postId);
	
	//delete
	void deletePost(Integer postId);
	
	//get All
	PostResponse getAllPosts(Integer pageNumber, Integer pageSize, String sortBy,  String sortDir);
	
	//get Single Post
	PostDto getPostById(Integer postId);
	
	
	//get all post by category
	List<PostDto>  getPostsByCategory(Integer categoryId);
	
	//get all post by user
	List<PostDto>  getPostsByUser(Integer userId);
	
	//search post 
	List<PostDto>  searchPosts(String keyword);

}

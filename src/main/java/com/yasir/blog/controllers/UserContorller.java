package com.yasir.blog.controllers;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yasir.blog.payloads.ApiResponse;
import com.yasir.blog.payloads.UserDto;
import com.yasir.blog.services.UserService;

@RestController
@RequestMapping("/api/users")
public class UserContorller {
	
	@Autowired
	private UserService userService;
	
	
	//POST - create user
	@PostMapping("/")
	public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto userDto){
		
		UserDto createUserDto = this.userService.createUser(userDto);
		return new ResponseEntity<>(createUserDto, HttpStatus.CREATED);
	}
	
	//PUT - update user
	@PutMapping("/{userId}")
	public ResponseEntity<UserDto> updateUser(@Valid @RequestBody UserDto userDto, @PathVariable Integer userId){ 

		UserDto updatedUser = this.userService.updateUser(userDto, userId);
		
		return  ResponseEntity.ok(updatedUser);
}
	
	//DELETE - delete user
	@DeleteMapping("/{userId}")
	public ResponseEntity<ApiResponse> updateUser( @PathVariable("userId") Integer uId){ 
		
		this.userService.deleteUser(uId);
		
		//return new ResponseEntity(Map.of("message", "User Deleted Successfully"), HttpStatus.OK);
		return new ResponseEntity<ApiResponse>(new ApiResponse("User Deleted Successfully", true), HttpStatus.OK);

		
	}
	
	//GET - get all users
	@GetMapping("/")
	public ResponseEntity<List<UserDto>> createUser(){
		
		return  ResponseEntity.ok(this.userService.getAllUsers());
	}
	
	//GET - get user
	@GetMapping("/{userId}")
	public ResponseEntity<UserDto> createUser(@PathVariable Integer userId){
		
		return  ResponseEntity.ok(this.userService.getUserById(userId));
	}
	
}
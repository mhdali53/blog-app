package com.yasir.blog.services;

import com.yasir.blog.payloads.CommentDto;

public interface CommentService {

	// note - by defult in interface all methods are public 
	
	CommentDto createComment(CommentDto commentDto, Integer postId);
	
	void deleteComment(Integer commentId);
}

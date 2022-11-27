package com.yasir.blog.repositories;
import org.springframework.data.jpa.repository.JpaRepository;

import com.yasir.blog.entities.Comment;

public interface CommentRepo extends JpaRepository<Comment, Integer>{

}
 
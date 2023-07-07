package com.example.images.repo;

import com.example.images.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface CommentRepository extends JpaRepository<Comment,Integer> {
}

package com.example.images.service;

import com.example.images.entity.Comment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CommentService {
    boolean create (Comment comment);
    boolean update(Comment comment);
    Page<Comment> findAll(Pageable pageable);
    Comment findById(int id);
}

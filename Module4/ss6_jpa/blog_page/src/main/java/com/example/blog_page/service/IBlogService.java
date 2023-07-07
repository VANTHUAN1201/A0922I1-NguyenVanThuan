package com.example.blog_page.service;

import com.example.blog_page.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBlogService {
    void create(Blog blog);
    void update(Blog blog);
    void delete(int id);
    List<Blog> findAll();
    List<Blog> findProductByTitle(String name);
    /*List<Blog> findAllByIdCategory (int idCategory);*/
    Blog findById(int id);
    Page<Blog> findAllPage(Pageable pageable);
}

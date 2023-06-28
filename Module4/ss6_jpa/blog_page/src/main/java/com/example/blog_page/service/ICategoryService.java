package com.example.blog_page.service;

import com.example.blog_page.model.Blog;
import com.example.blog_page.model.Category;

import java.util.List;

public interface ICategoryService {
    void create(Category category);
    void update(Category category);
    void delete(int id);
    List<Category> findAll();
    Category findById(int id);
}

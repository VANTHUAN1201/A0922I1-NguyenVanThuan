package codegym.vn.service;

import codegym.vn.entity.Blog;

import java.util.List;

public interface BlogService {
    boolean create(Blog blog);
    boolean update(Blog blog);
    Blog findById(int id);
    List<Blog> findAll();
    boolean deleteById(int id);
    List<Blog> findBlogByName(String name);
}

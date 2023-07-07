package com.example.blog_page.service;

import com.example.blog_page.model.Blog;
import com.example.blog_page.repository.IBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogServiceImpl implements IBlogService {
    @Autowired
    IBlogRepository repository;
    @Override
    public void create(Blog blog) {
        repository.save(blog);
    }

    @Override
    public void update(Blog blog) {
        repository.save(blog);
    }

    @Override
    public void delete(int id) {
        repository.deleteById(id);
    }

    @Override
    public List<Blog> findAll() {
        return repository.findAll();
    }

    @Override
    public List<Blog> findProductByTitle(String name) {
        return repository.findBlogByTitleContaining(name);
    }

    /*@Override
    public List<Blog> findAllByIdCategory(int idCategory) {
        return repository.findAll(idCategory);
    }*/

    @Override
    public Blog findById(int id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Page<Blog> findAllPage(Pageable pageable) {
        return repository.findAll(pageable);
    }


}

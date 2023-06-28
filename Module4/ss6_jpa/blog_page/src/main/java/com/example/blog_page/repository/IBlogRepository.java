package com.example.blog_page.repository;

import com.example.blog_page.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBlogRepository extends JpaRepository<Blog,Integer> {
//    @
//    public void findByIdCategory(int idCategory);
}

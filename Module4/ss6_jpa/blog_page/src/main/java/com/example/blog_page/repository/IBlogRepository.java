package com.example.blog_page.repository;

import com.example.blog_page.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IBlogRepository extends JpaRepository<Blog,Integer> {
//    @
//    public void findByIdCategory(int idCategory);

    List<Blog> findBlogByTitleContaining(String title);
//    @Query(value = "select b from Blog b where b.idCategory= :idCategory")
//    List<Blog> findAllByIdCategory(@Param("idCategory") int idCategory);
}

package com.example.blog_page.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCategory;
    @Column(columnDefinition = "nvarchar(255)")
    private String categoryName;
    @OneToMany(mappedBy = "category",fetch = FetchType.LAZY)
    private Set<Blog> blogs;

    public Category() {
    }

    public Category(int idCategory, String categoryName, Set<Blog> blogs) {
        this.idCategory = idCategory;
        this.categoryName = categoryName;
        this.blogs = blogs;
    }

    public int getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(int idCategory) {
        this.idCategory = idCategory;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Set<Blog> getBlogs() {
        return blogs;
    }

    public void setBlogs(Set<Blog> blogs) {
        this.blogs = blogs;
    }
}

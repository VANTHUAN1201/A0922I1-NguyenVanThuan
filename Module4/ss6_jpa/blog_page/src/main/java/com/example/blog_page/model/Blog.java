package com.example.blog_page.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.engine.internal.Cascade;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Entity
public class Blog implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(columnDefinition = "nvarchar(255)")
    private String title;
    @Column(columnDefinition = "")
    private String content;
    private Date date;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idCategory",referencedColumnName = "idCategory")
    @JsonManagedReference
    private Category category;

    public Blog() {
    }

    public Blog(int id, String title, String content, Date date, Category category) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.date = date;
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}

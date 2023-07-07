package com.example.blog_page.restcontroller;

import com.example.blog_page.model.Blog;
import com.example.blog_page.model.Category;
import com.example.blog_page.service.IBlogService;
import com.example.blog_page.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/blog")
public class BlogRestController {
    @Autowired
    IBlogService blogService;
    @Autowired
    ICategoryService categoryService;
    @GetMapping("/list")
    public ResponseEntity<List<Blog>> getBlog(){
        return new ResponseEntity<>(blogService.findAll(), HttpStatus.OK);
    }
    @GetMapping("/listCategory")
    public ResponseEntity<List<Category>> getCategory(){
        return new ResponseEntity<>(categoryService.findAll(), HttpStatus.OK);
    }
    @GetMapping("/view")
    public ResponseEntity<Blog> detailBlog(@RequestParam("id") int id){
        Blog b=blogService.findById(id);
        if (b!=null){
            return new ResponseEntity<>(b, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }
    @GetMapping("/search")
    public ResponseEntity<List<Blog>> search(@RequestParam("name") String name, Model model) {
        List<Blog> blogList = blogService.findProductByTitle(name);
        return new ResponseEntity<>(blogList, HttpStatus.OK);
    }
}

package com.stackroute.controller;

import com.stackroute.domain.Blog;
import com.stackroute.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/* Add annotation to declare this class as REST Controller */
@RestController
@RequestMapping("/api/v1/")
public class BlogController {
    private BlogService blogService;
    @Autowired
    public BlogController(BlogService blogService){this.blogService = blogService;}
    /* Provide implementation code for these methods */

    /*This method should save blog and return savedBlog Object */
    @PostMapping("/blog")
    public ResponseEntity<Blog> saveBlog(@RequestBody Blog blog) {
        Blog savedBlog = blogService.saveBlog(blog);
        return new ResponseEntity<>(savedBlog, HttpStatus.CREATED);
    }

    /*This method should fetch all blogs and return the list of all blogs */
    @GetMapping("/blogs")
    public ResponseEntity<List<Blog>> getAllBlogs() {
        return new ResponseEntity((List<Blog>) blogService.getAllBlogs(),HttpStatus.OK);
    }

    /*This method should fetch the blog taking its id and return the respective blog */
    @GetMapping("/blog/{id}")
    public ResponseEntity<Blog> getBlogById(@PathVariable("id") int id){
        Blog findBlog = blogService.getBlogById(id);
        return new ResponseEntity<>(findBlog, HttpStatus.FOUND);
    }

    /*This method should delete the blog taking its id and return the deleted blog */
    @DeleteMapping("/blog/{id}")
    public ResponseEntity<Blog> getBlogAfterDeleting(@PathVariable("id") int id) {
        Blog deleteBlog = blogService.getBlogById(id);
        blogService.deleteBlog(id);
        return new ResponseEntity<>(deleteBlog, HttpStatus.OK);
    }

    /*This method should update blog and return the updatedBlog */
    @PutMapping("/blog")
    public ResponseEntity<Blog> updateBlog(@RequestBody Blog blog) {
        Blog blogToUpdate  = blogService.updateBlog(blog);
        return new ResponseEntity<>(blogToUpdate,HttpStatus.OK);
    }
}
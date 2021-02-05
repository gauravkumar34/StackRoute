package com.stackroute.service;

import com.stackroute.domain.Blog;

import java.util.List;

public interface BlogService {
    /**
     * AbstractMethod to save a blog
     */
    Blog saveBlog(Blog blog);

    /**
     * AbstractMethod to get all blogs
     */
    List<Blog> getAllBlogs();

    /**
     * AbstractMethod to get blog by id
     */
    Blog getBlogById(int id);

    /**
     * AbstractMethod to delete blog by id
     */
    Blog deleteBlog(int id);

    /**
     * AbstractMethod to update a blog
     */
    Blog updateBlog(Blog blog);
}

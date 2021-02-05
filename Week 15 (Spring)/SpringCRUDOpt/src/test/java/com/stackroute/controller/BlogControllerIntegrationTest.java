package com.stackroute.controller;

import com.stackroute.domain.Blog;
import com.stackroute.service.BlogService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class BlogControllerIntegrationTest {

    @Autowired
    private BlogService blogService;
    private Blog blog;
    private List<Blog> blogList;


    @BeforeEach
    public void setUp() {
        blog = new Blog();
        blog.setBlogId(1);
        blog.setBlogTitle("DemoBlog");
        blog.setAuthorName("Imneet");
        blog.setBlogContent("SampleBlogforTesting");
        blogList = new ArrayList<>();
        blogList.add(blog);
    }

    @AfterEach
    public void tearDown() {
        blog = null;
    }

    @Test
    void givenBlogToSaveThenShouldReturnTheSavedBlog() throws Exception {
        Blog savedBlog = blogService.saveBlog(blog);
        assertNotNull(savedBlog);
        assertEquals(blog.getBlogId(), savedBlog.getBlogId());
    }

    @Test
    public void givenGetAllBlogsThenShouldReturnListOfAllBlogsAndBlogListShouldNotBeNull() throws Exception {
        List<Blog> blogList = blogService.getAllBlogs();
        assertNotNull(blogList);
    }

    @Test
    public void givenBlogToUpdateThenShouldReturnUpdatedBlog() throws Exception {
        blog.setBlogContent("Updated Blog content");
        blogService.updateBlog(blog);
        assertEquals("Updated Blog content", blog.getBlogContent());
    }
}




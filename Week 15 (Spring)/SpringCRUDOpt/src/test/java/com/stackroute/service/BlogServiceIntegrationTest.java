package com.stackroute.service;

import com.stackroute.domain.Blog;
import com.stackroute.repository.BlogRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class BlogServiceIntegrationTest {

    @Autowired
    private BlogRepository blogRepository;

    @Autowired
    private BlogServiceImpl blogService;
    private Blog blog1, blog2, blog3;
    private List<Blog> blogList;
    private Optional optional;

    @BeforeEach
    public void setUp() {

        blogList = new ArrayList<>();
        blog1 = new Blog(1, "Blog", "Imneet", "SampleBlogforTesting");
        blog2 = new Blog(2, "Blog 1", "John", "Sample Blog 1 for Testing");
        blog3 = new Blog(3, "Blog2", "Kurzen", "Sample Blog");
        blogList.add(blog1);
        blogList.add(blog2);
        blogList.add(blog3);
    }

    @AfterEach
    public void tearDown() {
        blog1 = blog2 = blog3 = null;
        blogList = null;
    }

    @Test
    public void givenBlogToSaveThenShouldReturnSavedBlog() {
        Blog savedBlog = blogRepository.save(blog1);
        assertNotNull(savedBlog);
        assertEquals(blog1.getBlogId(), savedBlog.getBlogId());
    }

    @Test
    public void givenGetAllBlogsThenShouldReturnListOfAllBlogs() {
        List<Blog> blogList = (List<Blog>) blogRepository.findAll();
        assertNotNull(blogList);
    }

}

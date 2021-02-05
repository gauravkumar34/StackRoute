package com.stackroute.service;

import com.stackroute.domain.Blog;

import com.stackroute.repository.BlogRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class BlogServiceTest {
    @Mock
    private BlogRepository blogRepository;

    @InjectMocks
    private BlogServiceImpl blogService;
    private Blog blog,blog1;
    private List<Blog> blogList;
    private Optional optional;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);

        blog = new Blog(1, "SampleBlog", "Imneet", "SampleBlogforTesting");
        blog1 = new Blog(2, "Blog 1", "John", "Sample Blog 1 for Testing");
        optional = Optional.of(blog);
    }

    @AfterEach
    public void tearDown() {
        blog = null;
    }

    @Test
    public void givenBlogToSaveThenShouldReturnSavedBlog() {
        when(blogRepository.save(any())).thenReturn(blog);
        assertEquals(blog, blogService.saveBlog(blog));
        verify(blogRepository, times(1)).save(any());
    }

    @Test
    public void givenBlogToSaveThenShouldNotReturnSavedBlog() {
        when(blogRepository.save(any())).thenThrow(new RuntimeException());
        Assertions.assertThrows(RuntimeException.class,() -> {
            blogService.saveBlog(blog);
        });
        verify(blogRepository, times(1)).save(any());
    }

    @Test
    public void givenGetAllBlogsThenShouldReturnListOfAllBlogs() {
        blogRepository.save(blog);
        //stubbing the mock to return specific data
        when(blogRepository.findAll()).thenReturn(blogList);
        List<Blog> blogList1 = blogService.getAllBlogs();
        assertEquals(blogList, blogList1);
        verify(blogRepository, times(1)).save(blog);
        verify(blogRepository, times(1)).findAll();
    }

    @Test
    public void givenBlogIdThenShouldReturnRespectiveBlog() {
        when(blogRepository.findById(anyInt())).thenReturn(Optional.of(blog));
        Blog retrievedBlog = blogService.getBlogById(blog.getBlogId());
        verify(blogRepository, times(1)).findById(anyInt());

    }

    @Test
    void givenBlogIdToDeleteThenShouldReturnDeletedBlog() {
        when(blogRepository.findById(blog.getBlogId())).thenReturn(optional);
        Blog deletedBlog = blogService.deleteBlog(1);
        assertEquals(1, deletedBlog.getBlogId());

        verify(blogRepository, times(1)).findById(blog.getBlogId());
        verify(blogRepository, times(1)).deleteById(blog.getBlogId());
    }

    @Test
    void givenBlogIdToDeleteThenShouldNotReturnDeletedBlog() {
        when(blogRepository.findById(blog.getBlogId())).thenReturn(Optional.empty());
        Blog deletedBlog = blogService.deleteBlog(1);
        verify(blogRepository, times(1)).findById(blog.getBlogId());
    }

    @Test
    public void givenBlogToUpdateThenShouldReturnUpdatedBlog() {
        when(blogRepository.findById(blog.getBlogId())).thenReturn(optional);
        when(blogRepository.save(blog)).thenReturn(blog);
        blog.setBlogContent("SampleBlogforTesting");
        Blog blog1 = blogService.updateBlog(blog);
        assertEquals(blog1.getBlogContent(), "SampleBlogforTesting");
        verify(blogRepository, times(1)).save(blog);
        verify(blogRepository, times(2)).findById(blog.getBlogId());
    }

    @Test
    public void givenBlogToUpdateThenShouldNotReturnUpdatedBlog() {
        when(blogRepository.findById(blog.getBlogId())).thenReturn(Optional.empty());
        Blog blog1 = blogService.updateBlog(blog);
        assertNull(blog1);
        verify(blogRepository, times(1)).findById(blog.getBlogId());
    }
}
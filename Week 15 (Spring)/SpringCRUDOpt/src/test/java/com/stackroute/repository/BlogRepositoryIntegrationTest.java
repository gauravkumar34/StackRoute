package com.stackroute.repository;

import com.stackroute.domain.Blog;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class BlogRepositoryIntegrationTest {

    @Autowired
    private BlogRepository blogRepository;
    private Blog blog;

    @BeforeEach
    public void setUp() {
        blog = new Blog();
        blog.setBlogId(1);
        blog.setBlogTitle("Blog1");
        blog.setAuthorName("Imneet");
        blog.setBlogContent("Sample content");
    }
    @AfterEach
    public void tearDown() {
        blogRepository.deleteAll();
        blog = null;
    }

    @Test
    public void givenBlogToSaveThenShouldReturnSavedBlog() {
        blogRepository.save(blog);
        Blog fetchedBlog = blogRepository.findById(blog.getBlogId()).get();
        assertEquals(1, fetchedBlog.getBlogId());
    }


    @Test
    public void givenGetAllBlogsThenShouldReturnListOfAllBlogs() {
        Blog blog = new Blog(2, "Demo2", "Imneet", "Sample2");
        Blog blog1 = new Blog(3, "Demo3", "Imneet", "Sample3");
        blogRepository.save(blog);
        blogRepository.save(blog1);

        List<Blog> blogList = (List<Blog>) blogRepository.findAll();
        assertEquals("Demo3", blogList.get(1).getBlogTitle());
    }

    @Test
    public void givenBlogIdThenShouldReturnRespectiveBlog() {
        Blog blog = new Blog(9, "Demo9", "Imneet", "SampleBlog");
        Blog blog1 = blogRepository.save(blog);
        Optional<Blog> optional = blogRepository.findById(blog1.getBlogId());
        assertEquals(blog1.getBlogId(), optional.get().getBlogId());
        assertEquals(blog1.getBlogTitle(), optional.get().getBlogTitle());
        assertEquals(blog1.getAuthorName(), optional.get().getAuthorName());
        assertEquals(blog1.getBlogContent(), optional.get().getBlogContent());
    }

    @Test
    public void givenBlogIdToDeleteThenShouldReturnDeletedBlog() {
        Blog blog = new Blog(4, "Demo4", "Imneet", "Sample4");
        blogRepository.save(blog);
        blogRepository.deleteById(blog.getBlogId());
        Optional optional = blogRepository.findById(blog.getBlogId());
        assertEquals(Optional.empty(), optional);
    }

}
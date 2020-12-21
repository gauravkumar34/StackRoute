package com.stackroute.defaultmethods;

import com.stackroute.defaultmethods.domain.Blog;
import com.stackroute.defaultmethods.service.BlogAuthoringServiceImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BlogAuthoringServiceImplTests {
    private static final String MSG_01 = "Check the logic of your method processBlog";
    private static final String MSG_02 = "Check the logic of your method publishBlog";
    private static final String MSG_03 = "Check the logic of your method rejectBlogForInformalWords";

    private BlogAuthoringServiceImpl blogAuthoringService;
    private Blog blogOne;
    private Blog blogTwo;

    @BeforeEach
    public void setUp() {
        blogAuthoringService = new BlogAuthoringServiceImpl();
        blogOne = new Blog(1, "Introduction to Default Interface", "Hey dude, this is a crazy blog...", "Richardson");
        blogTwo = new Blog(2, "Why Docker?", "In this post, I'll explain what is Docker", "Richardson");
    }

    @AfterEach
    public void tearDown() {
        blogAuthoringService = null;
    }

    @Test
    public void givenValidBlogContentThenShouldPublishBlog() {
        String output = "Blog published successfully";
        assertEquals(output, blogAuthoringService.processBlog(blogTwo), MSG_01);
    }

    @Test
    public void givenInValidBlogContentThenShouldRejectBlog() {
        String output = "Blog is rejected!";
        assertEquals(output, blogAuthoringService.processBlog(blogOne), MSG_01);
    }


    @Test
    public void givenEmptyBlogContentThenShouldRejectBlog() {
        String output = "Blog is rejected!";
        blogTwo.setBlogContent("");
        assertEquals(output, blogAuthoringService.processBlog(blogTwo), MSG_01);
    }

    @Test
    public void givenBlankBlogContentThenShouldRejectBlog() {
        String output = "Blog is rejected!";
        blogTwo.setBlogContent(" ");
        assertEquals(output, blogAuthoringService.processBlog(blogTwo), MSG_01);
    }

    @Test
    public void givenValidBlogWhenPublishedThenShouldReturnSuccessMessage() {
        String output = "Blog published successfully";
        assertEquals(output, blogAuthoringService.publishBlog(blogTwo), MSG_02);
    }


    @Test
    public void givenValidBlogContentWhenCheckedForInformalWordsThenShouldReturnFalse() {
        assertFalse(blogAuthoringService.rejectBlogForInformalWords(blogTwo), MSG_03);
    }

    @Test
    public void givenValidBlogContentWhenCheckedForInformalWordsThenShouldReturnTrue() {
        assertTrue(blogAuthoringService.rejectBlogForInformalWords(blogOne), MSG_03);
    }

}

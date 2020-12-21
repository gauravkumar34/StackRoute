package com.stackroute.defaultmethods.service;

import com.stackroute.defaultmethods.domain.Blog;

public class BlogAuthoringServiceImpl implements BlogAuthoringService {

    /* Override this method to return a string message */
    public String publishBlog(Blog blog) {

        if (rejectBlogForInformalWords(blog)) {
            return "Blog is rejected!";
        } else {
            return "Blog published successfully";
        }
    }

    /* Write the logic for processing the blog */
    public String processBlog(Blog blog) {
        if (rejectBlogForInformalWords(blog))
            return "Blog is rejected!";
        else
            return "Blog published successfully";
    }

    // Default method rejectBlogForInformalWords(Blog blog): boolean
    public boolean rejectBlogForInformalWords(Blog blog) {
        Boolean s = false;
        if (blog.getBlogContent().isEmpty()) {
            return true;
        }
        if (blog.getBlogContent().isBlank())
            return true;
        for (String b : informalWords) {
            if (blog.getBlogContent().contains(b)) {
                s = true;
            } else {
                s = false;
            }

        }
        // if (s) {
        // return "Blog is rejected!";
        // } else {
        // return "Blog published successfully";
        // }

        return s;
    }

}

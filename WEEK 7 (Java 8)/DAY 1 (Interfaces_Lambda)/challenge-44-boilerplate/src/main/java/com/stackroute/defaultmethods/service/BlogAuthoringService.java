package com.stackroute.defaultmethods.service;

import com.stackroute.defaultmethods.domain.Blog;

public interface BlogAuthoringService {
    String[] informalWords = { "chill", "dude", "crap", "crazy" };

    String publishBlog(Blog blog);

    /*
     * Create the default method to reject the blog content with informal
     * words,empty and blank blog content
     */

}

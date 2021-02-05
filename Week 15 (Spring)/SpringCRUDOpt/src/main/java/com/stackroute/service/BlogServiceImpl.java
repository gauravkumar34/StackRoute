package com.stackroute.service;


import com.stackroute.domain.Blog;
import com.stackroute.repository.BlogRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/* Add annotation to declare this class as Service class.
 * Also it should implement BlogService Interface and override all the implemented methods.*/
@Service
public class BlogServiceImpl implements BlogService{

    private BlogRepository blogRepository;
    @Autowired
    public BlogServiceImpl(BlogRepository blogRepository){this.blogRepository = blogRepository;}

    @Override
    public Blog saveBlog(Blog blog) {
        return blogRepository.save(blog);
    }

    @Override
    public List<Blog> getAllBlogs() {
        return (List<Blog>) blogRepository.findAll();
    }

    @Override
    public Blog getBlogById(int id) {
       Blog blog = new Blog();
       Blog b = null;
        Optional<Blog> optionalBlog = blogRepository.findById(id);
       if(optionalBlog.isPresent()){
           b = optionalBlog.get();
           BeanUtils.copyProperties(b,blog);
       }
       return blog;
    }

    @Override
    public Blog deleteBlog(int id) {
        Blog b = getBlogById(id);
        blogRepository.deleteById(id);
        return b;

    }

    @Override
    public Blog updateBlog(Blog blog) {
        Blog updatedBlog = null;
        Optional optional = blogRepository.findById(blog.getBlogId());
        if(optional.isPresent()){
            Blog getBlog = blogRepository.findById(blog.getBlogId()).get();
            getBlog.setBlogContent(blog.getBlogContent());
            updatedBlog = saveBlog(getBlog);
        }
        return updatedBlog;
//        Blog blogToUpdate = getBlogById(blog.getBlogId());
//        blogToUpdate.setBlogId(blog.getBlogId());
//        blogToUpdate.setBlogTitle(blog.getBlogTitle());
//        blogToUpdate.setAuthorName(blog.getAuthorName());
//        blogToUpdate.setBlogContent(blog.getBlogContent());
//        return blogRepository.save(blogToUpdate);
    }
}

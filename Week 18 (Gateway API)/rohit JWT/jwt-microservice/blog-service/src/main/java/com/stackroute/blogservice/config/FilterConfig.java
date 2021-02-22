package com.stackroute.blogservice.config;


import com.stackroute.blogservice.filter.JwtFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfig {
    public FilterRegistrationBean jwtFilter(){
        FilterRegistrationBean filter =new FilterRegistrationBean();
        filter.setFilter(new JwtFilter());
        filter.addUrlPatterns("/api/v1/*");
        return filter;
    }
}

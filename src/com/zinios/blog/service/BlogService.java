package com.zinios.blog.service;

import java.util.List;

import com.zinios.blog.bean.Blog;

public interface BlogService {
    
   Blog findById(long id);
    
   Blog findByName(String name);
    
   void saveBlog(Blog blog);
    
   void updateBlog(Blog blog);
    
   void deleteBlogById(long id);

   List<Blog> findAllBlogs();
    
   void deleteAllBlogs();
   
   int getMaxId();
    
   //boolean isBlogExist(Blog blog);
    
}

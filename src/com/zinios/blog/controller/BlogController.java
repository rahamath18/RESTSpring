package com.zinios.blog.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.zinios.blog.bean.Blog;
import com.zinios.blog.service.BlogService;

@RestController
@RequestMapping("/api")
public class BlogController {
 
    //public static final org.slf4j.Logger logger = LoggerFactory.getLogger(RestApiController.class);
 
    @Autowired
    BlogService blogService; //Service which will do all data retrieval/manipulation work
 
    // -------------------Retrieve All Blogs---------------------------------------------
 
    @RequestMapping(value = "/blog/", method = RequestMethod.GET)
    public ResponseEntity<List<Blog>> listAllBlogs() {
        List<Blog> blogs = blogService.findAllBlogs();
        if (blogs.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
            // You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Blog>>(blogs, HttpStatus.OK);
    }
 
    // -------------------Retrieve Single Blog------------------------------------------
 
    @RequestMapping(value = "/blog/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getBlog(@PathVariable("id") long id) {
        //logger.info("Fetching Blog with id {}", id);
        Blog blog = blogService.findById(id);
         
        return new ResponseEntity<Blog>(blog, HttpStatus.OK);
    }
 
    // -------------------Create a Blog-------------------------------------------
 
//    @RequestMapping(value = "/blog/", method = RequestMethod.POST)
//    public ResponseEntity<?> createBlog(@RequestBody Blog blog, UriComponentsBuilder ucBuilder) {
//      ///  logger.info("Creating Blog : {}", blog);
// 
//        blogService.saveBlog(blog);
// 
//        HttpHeaders headers = new HttpHeaders();
//        headers.setLocation(ucBuilder.path("/api/blog/{id}").buildAndExpand(blog.getId()).toUri());
//        return new ResponseEntity<String>(headers, HttpStatus.CREATED);
//    }
    
    @RequestMapping(value = "/blog", method = RequestMethod.POST)
    public ResponseEntity<String> createBlog(@RequestBody Blog blog) 
    {
        System.out.println("BlogController|createBlog|...."+blog);
        blogService.saveBlog(blog);
       // HttpHeaders headers = new HttpHeaders();
        //headers.add("Accept", MediaType.APPLICATION_JSON_VALUE);
        //return new ResponseEntity(headers, HttpStatus.CREATED);
        return new ResponseEntity(HttpStatus.CREATED);
    }
 
    // ------------------- Update a Blog ------------------------------------------------
 
    @RequestMapping(value = "/blog/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> updateBlog(@PathVariable("id") long id, @RequestBody Blog blog) {
        //logger.info("Updating Blog with id {}", id);
 
        Blog currentBlog = blogService.findById(id);
 
        
 
        blogService.updateBlog(currentBlog);
        return new ResponseEntity<Blog>(currentBlog, HttpStatus.OK);
    }
 
    // ------------------- Delete a Blog-----------------------------------------
 
    @RequestMapping(value = "/blog/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteBlog(@PathVariable("id") long id) {
       // logger.info("Fetching & Deleting Blog with id {}", id);
 
        Blog blog = blogService.findById(id);
        
        blogService.deleteBlogById(id);
        return new ResponseEntity<Blog>(HttpStatus.NO_CONTENT);
    }
 
    // ------------------- Delete All Blogs-----------------------------
 
    @RequestMapping(value = "/blog/", method = RequestMethod.DELETE)
    public ResponseEntity<Blog> deleteAllBlogs() {
     //   logger.info("Deleting All Blogs");
 
        blogService.deleteAllBlogs();
        return new ResponseEntity<Blog>(HttpStatus.NO_CONTENT);
    }
 
}

package com.zinios.blog.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

import com.zinios.blog.bean.Blog;
import com.zinios.blog.db.DBConnectionUtil;

@Service("blogService")
public class BlogServiceImpl implements BlogService{
     
     
    private static List<Blog> blogs;
     
    static{
        blogs= populateDummyBlogs();
    }
 
    public List<Blog> findAllBlogs() {
    	
    	List<Blog> blogList = new ArrayList<Blog>();
    	
    	try {
//			Connection connection = DBConnectionUtil.getDBConnection();
//			
//			String sql = "SELECT * FROM ZBLOG_BLOG";
//
//			Statement stmt = connection.createStatement();
//			ResultSet rs = stmt.executeQuery(sql);
//			while(rs.next()) {
//				Blog blog = new Blog(
//						rs.getInt("ID"),
//						rs.getString("CONTENT"),
//						rs.getString("BLOG_STATUS"),
//						rs.getString("BLOG_COMMENT_COUNT"),
//						rs.getString("VERSION"),
//						rs.getString("CREATED_BY"),
//						rs.getDate("CREATED_DATE"),
//						rs.getString("MODIFIED_BY"),
//						rs.getDate("MODIFIED_DATE"));
//				blogList.add(blog);
//			}
//			rs.close();
//			stmt.close();
//			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
    	
    	Blog blog = new Blog(1,"dummy_content", "NEW", 0, 1, 
    			"user1", new java.sql.Date(System.currentTimeMillis()), null, null);
		blogList.add(blog);
        return blogList;
    }
     
    public Blog findById(long id) {
    	if(id == 1) {
    	Blog blog = new Blog(1,"dummy_content", "NEW", 0, 1, 
    			"user1", new java.sql.Date(System.currentTimeMillis()), null, null);
        return blog;
    } else 
    	return null;
    }
     
    public Blog findByName(String name) {
         
        return null;
    }
     
    public void saveBlog(Blog blog) {
        System.out.println("BlogServiceImpl|saveBlog|...."+blog);

        //blogs.add(blog);
    	
    	blog.setId(getMaxId());
    	// use hibernate to store the blog obj
    	
    	try {
			Connection connection = new DBConnectionUtil().getDBConnection();
			
			String sql = "INSERT INTO ZBLOG_BLOG (ID,CONTENT,BLOG_STATUS,VERSION,"
					+ "CREATED_BY,CREATED_DATE)" +
			        "VALUES (?,?,?,?,?,?)";

			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, blog.getId());
			ps.setString(2, blog.getContent());
			ps.setString(3, "CREATED");
			ps.setInt(4, 1);
			ps.setString(5, blog.getCreatedBy());
			ps.setDate(6, blog.getCreatedDate());
			ps.executeUpdate(); 
			
			ps.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }
 
    public void updateBlog(Blog blog) {
        int index = blogs.indexOf(blog);
        blogs.set(index, blog);
    }
 
    public void deleteBlogById(long id) {
         
        for (Iterator<Blog> iterator = blogs.iterator(); iterator.hasNext(); ) {
            Blog blog = iterator.next();
            if (blog.getId() == id) {
                iterator.remove();
            }
        }
    }
 
    public void deleteAllBlogs(){
        blogs.clear();
    }
 
    private static List<Blog> populateDummyBlogs(){
        List<Blog> blogs = new ArrayList<Blog>();
        return blogs;
    }
    
    public int getMaxId() {
    	try {
			Connection connection = new DBConnectionUtil().getDBConnection();
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT max(ID) as ID FROM ZBLOG_BLOG");
			while(rs.next()) {
				return rs.getInt(1) + 1;
			}
			
			rs.close();
			stmt.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	return -1;
    }
 
}
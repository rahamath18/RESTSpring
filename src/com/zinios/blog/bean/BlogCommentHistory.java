package com.zinios.blog.bean;

import java.io.Serializable;
import java.sql.Date;

public class BlogCommentHistory implements Serializable {  
	   private static final long serialVersionUID = 1L; 
	   private int id;
	   private int blogId; 
	   private String comment; 
	   private String createdBy;
	   private Date createdDate;
	   	   	   
	public BlogCommentHistory(int id, int blogId, String comment, String createdBy, Date createdDate) {
		super();
		this.id = id;
		this.blogId = blogId;
		this.comment = comment;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getBlogId() {
		return blogId;
	}
	public void setBlogId(int blogId) {
		this.blogId = blogId;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	   
}
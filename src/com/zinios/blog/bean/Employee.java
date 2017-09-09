package com.zinios.blog.bean;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Employee implements Serializable {
	
	   private static final long serialVersionUID = 1L; 

	
	 private int id; 
	   private String content; 
	   private String blogStatus;
	   private String blogCommentCount;
	   
	public Employee() {
	}
	
	
	public Employee(/*int id, String content, String blogStatus, String blogCommentCount*/
			@JsonProperty("id")int id,
			@JsonProperty("content")String content,
			@JsonProperty("blogStatus")String blogStatus,
			@JsonProperty("blogCommentCount")String blogCommentCount) {
		this.id = id;
		this.content = content;
		this.blogStatus = blogStatus;
		this.blogCommentCount = blogCommentCount;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getBlogStatus() {
		return blogStatus;
	}
	public void setBlogStatus(String blogStatus) {
		this.blogStatus = blogStatus;
	}
	public String getBlogCommentCount() {
		return blogCommentCount;
	}
	public void setBlogCommentCount(String blogCommentCount) {
		this.blogCommentCount = blogCommentCount;
	}

}

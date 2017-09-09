package com.zinios.blog.bean;

import java.io.Serializable;
import java.sql.Date;

public class Blog implements Serializable {  
   private static final long serialVersionUID = 1L; 
   private int id; 
   private String content; 
   private String blogStatus;
   private int blogCommentCount;
   private int version;
   private String createdBy;
   private Date createdDate;
   private String modifiedBy;
   private Date modifiedDate;
   
	public Blog() {
		super();
	}
public Blog(int id, String content, String blogStatus, int blogCommentCount, int version, String createdBy,
		Date createdDate, String modifiedBy, Date modifiedDate) {
	super();
	this.id = id;
	this.content = content;
	this.blogStatus = blogStatus;
	this.blogCommentCount = blogCommentCount;
	this.version = version;
	this.createdBy = createdBy;
	this.createdDate = createdDate;
	this.modifiedBy = modifiedBy;
	this.modifiedDate = modifiedDate;
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
public int getBlogCommentCount() {
	return blogCommentCount;
}
public void setBlogCommentCount(int blogCommentCount) {
	this.blogCommentCount = blogCommentCount;
}
public int getVersion() {
	return version;
}
public void setVersion(int version) {
	this.version = version;
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
public String getModifiedBy() {
	return modifiedBy;
}
public void setModifiedBy(String modifiedBy) {
	this.modifiedBy = modifiedBy;
}
public Date getModifiedDate() {
	return modifiedDate;
}
public void setModifiedDate(Date modifiedDate) {
	this.modifiedDate = modifiedDate;
}
   
   
   

}

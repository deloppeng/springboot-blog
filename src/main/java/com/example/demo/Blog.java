package com.example.demo;

import org.springframework.data.annotation.Id;

public class Blog {
	@Id
	public String id;
	public String title;
	public String content;
	private String createTime;
	private String userName;
	  
	public String getId() {
		return id; 
	} 
	public void setId(String id) {
		this.id = id; 
	} 
	
	public String getTitle() {
		return title; 
	} 
	public void setTitle(String title) {
		this.title = title; 
	}
	
	public String getContent() {
		return content; 
	} 
	public void setContent(String content) {
		this.content = content; 
	}
	
	public String getCreateTime() {
        return createTime;
    }
    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }
    
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
    
}

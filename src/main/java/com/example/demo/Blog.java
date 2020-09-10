package com.example.demo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection="blog")
public class Blog {
	@Id
    public String id;
    @Field("title")
    public String title;
    @Field("content")
    public String content;
    
    public Blog() {}
    
    public Blog(String title, String content) {
        this.title = title;
        this.content = content;
    }
}

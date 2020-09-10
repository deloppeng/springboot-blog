package com.example.demo;

import java.io.Console;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Blog;
import com.example.demo.BlogRepo;

@RestController
@RequestMapping(value="/api/blog")
public class BlogController {
	@Autowired
    private BlogRepo blogRepo;
	
	/**
     * 查詢全部
     */
	@GetMapping(value="/all", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Blog> getAllCustomers() {
        return blogRepo.findAll();
    }
	
	/**
     * 新增一筆資料
     */
    @PostMapping(value="/add", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Blog createCustomer(@RequestBody Blog blog) {
    	System.out.println(blog);
//        blog.setId(ObjectId.get().toHexString());
//        blogRepo.save(blog);
        return blog;
    }
	
}

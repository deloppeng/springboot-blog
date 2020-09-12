package com.example.demo;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/api/blog")
public class BlogController {
	@Autowired
    private BlogRepo blogRepo;
	
	/**
     * 查詢全部
     */
	@GetMapping("/all")
    public List<Blog> getAllCustomers() {
        return blogRepo.findAll();
    }
	
	/**
     * 查詢name
     */
	@GetMapping("/find/{name}")
    public List<Blog> findUser(@PathVariable("name") String name) {
        return blogRepo.findByuserName(name);
    }
	
	/**
     * 新增一筆資料
     */
    @PostMapping("/add")
    public void createblogpost(@ModelAttribute Blog blog, HttpServletResponse response) {    	
    	Blog blogObj = new Blog();
    	Date dNow = new Date( );
	    SimpleDateFormat dataid = new SimpleDateFormat ("yyyyMMddhhmmss");
	    SimpleDateFormat dataCT = new SimpleDateFormat ("yyyy-MM-dd hh:mm:ss");
	    
    	blogObj.setId(dataid.format(dNow).toString());
    	blogObj.setUserName(blog.getUserName());
    	blogObj.setTitle(blog.getTitle());
    	blogObj.setContent(blog.getContent());
    	blogObj.setCreateTime(dataCT.format(dNow).toString());
    	blogRepo.save(blogObj);
    	
    	try {
			response.sendRedirect("/"+blog.getUserName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}

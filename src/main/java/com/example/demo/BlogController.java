package com.example.demo;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
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
     * 新增一筆資料
     */
    @PostMapping("/add")
    public void createblogpost(@ModelAttribute Blog blog, HttpServletResponse response) {
    	System.out.println("add title"+blog.getTitle());
    	System.out.println("add content"+blog.getContent());
    	
    	Blog blogObj = new Blog();
    	Date dNow = new Date( );
	    SimpleDateFormat dataid = new SimpleDateFormat ("yyyyMMddhhmmss");
	    SimpleDateFormat dataCT = new SimpleDateFormat ("yyyy-MM-dd hh:mm:ss");
	    
    	blogObj.setId(dataid.format(dNow).toString());
    	blogObj.setTitle(blog.getTitle());
    	blogObj.setContent(blog.getContent());
    	blogObj.setCreateTime(dataCT.format(dNow).toString());
    	blogRepo.save(blogObj);
    	
    	try {
			response.sendRedirect("/");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    @GetMapping("/test") 
	public String test() {
//		SimpleDateFormat str = new SimpleDateFormat ("yyyyMMddhhmmss");
		Date dNow = new Date( );
	    SimpleDateFormat ft = new SimpleDateFormat ("yyyyMMddhhmmss");
	    String str = ft.format(dNow).toString();
//		String str = "hello world";
		return str.toString(); 
	} 
    
    
    

	
}

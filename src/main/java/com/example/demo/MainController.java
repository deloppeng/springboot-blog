package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class MainController {

	@Autowired
    private BlogRepo blogRepo;
	
	public Blog blog = new Blog();
    
	@GetMapping("/{name}") 
	public String blogForm(Model model, @PathVariable("name") String name) {
		model.addAttribute("name", name);
		
		//get all data in db
		List<Blog> data = blogRepo.findByuserName(name);
		
		model.addAttribute("data", data);
		
		blog.setUserName(name);
		model.addAttribute("blog", blog);
		return "blogForm"; 
	} 

	public Blog getBlog() {
		return blog; 
	} 
	public void setBlog(Blog blog) {
		this.blog = blog; 
	} 
	
	
	
	
}

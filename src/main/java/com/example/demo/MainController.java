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
    
	@GetMapping("/{name}") 
	public String blogForm(Model model, @PathVariable("name") String name) {
		model.addAttribute("name", name);
		
		//get all data in db
		List<Blog> aaa = blogRepo.findAll();
		
		model.addAttribute("data", aaa);
		model.addAttribute("blog", new Blog());
		
		return "blogForm"; 
	} 

	
	
	
}

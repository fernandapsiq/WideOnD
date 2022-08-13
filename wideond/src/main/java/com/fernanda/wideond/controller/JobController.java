package com.fernanda.wideond.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fernanda.wideond.dto.PostData;

@Controller
@RequestMapping("job")
public class JobController {
	
	@GetMapping("form")
	public String form(PostData postRequest) {
		return "job/form";
	}
	
	
	
	@PostMapping("new/post")
	public String newJob() {
		
		return "redirect:/home";
	}
	
}

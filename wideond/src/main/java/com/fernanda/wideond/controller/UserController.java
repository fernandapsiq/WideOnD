package com.fernanda.wideond.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fernanda.wideond.entities.Job;
import com.fernanda.wideond.repositories.JobRepository;
import com.fernanda.wideond.services.JobService;

@Controller
@RequestMapping("user")
public class UserController {
	
	@Autowired
	private JobRepository jobRepository;
	
	@Autowired
	private JobService jobService;
	
	@GetMapping("jobs")
	public String home(Model model, Principal principal) {
		List<Job> jobs = jobRepository.findAll();
		model.addAttribute("jobs", jobs);
		return "user/home";
	}
	
	@GetMapping("jobs/{status}")
	public String filterByStatus(@PathVariable("status") String status, Model model, Principal principal) {
		
		return "user/home";
	}
	
}

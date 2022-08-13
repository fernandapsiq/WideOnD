package com.fernanda.wideond.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.fernanda.wideond.entities.Post;
import com.fernanda.wideond.repositories.PostRepository;

@Controller
public class HomeController {
	
	@Autowired
	private PostRepository postRepository;
	
	@GetMapping("/home")
	public String users(Model model) {
		List<Post> posts = postRepository.findAll();
		model.addAttribute("posts", posts);
		return "home";
	}
	
	
	
}

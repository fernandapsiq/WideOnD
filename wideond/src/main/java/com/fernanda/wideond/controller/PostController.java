package com.fernanda.wideond.controller;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fernanda.wideond.dto.PostData;
import com.fernanda.wideond.entities.Post;
import com.fernanda.wideond.repositories.PostRepository;

@Controller
@RequestMapping("post")
public class PostController {

	@Autowired
	private PostRepository postRepository;
	
	@GetMapping("new")
	public String postForm(PostData postData) {
		return "feed/post";
	}
	
	@PostMapping("new") @Transactional
	public String submitForm(@Valid PostData postData, BindingResult result) {

		// any error in validation dto
		if(result.hasErrors()) {
			return "feed/post";
		}
		
		Post postEntity = postData.toPost();
		postRepository.save(postEntity);
		
		return "redirect:/home";
	}
	
	@ExceptionHandler(IllegalArgumentException.class)
	public String onError() {
		return "redirect:/home";
	}
	
}

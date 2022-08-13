package com.fernanda.wideond.controller;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fernanda.wideond.dto.BasicRegisterForm;
import com.fernanda.wideond.dto.UserDetailsData;
import com.fernanda.wideond.services.UserService;

@Controller
@RequestMapping("register")
public class RegisterController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping
	public String register(BasicRegisterForm basicForm) {
		return "register";
	}
		
	@PostMapping @Transactional
	public String register(@Valid BasicRegisterForm basicForm,
			BindingResult result) {

		if(result.hasErrors()) {
			result.getAllErrors().forEach(System.out::println);
			return "redirect:/login";
		}
		
		userService.register(basicForm);		
		
		return "redirect:/login";
	}
	
	@GetMapping("details")
	public String detailsRegister(UserDetailsData userDetailsData) {
		return "redirect:/login";
	}
	
	@PostMapping("details") @Transactional
	public String detailsRegister(@Valid UserDetailsData userDetailsData,
			BindingResult result) {

		if(result.hasErrors()) {
			return "redirect:/register";
		}
		
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		
		userService.updateDetails(username, userDetailsData);		
		 
		return "redirect:/user/details";
	}
	
	@ExceptionHandler(IllegalArgumentException.class)
	public String onError() {
		return "redirect:/home";
	}
	
}

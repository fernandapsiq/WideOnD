package com.fernanda.wideond.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.validation.constraints.NotBlank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;

import com.fernanda.wideond.entities.Job;
import com.fernanda.wideond.entities.Post;
import com.fernanda.wideond.repositories.UserRepository;

public class PostData {

	@Autowired
	private UserRepository userRepository;
	
	//------------------
	
	@NotBlank
	private String title;

	@NotBlank
	private String description;
	
	private String companyWebsite;
	
	private String imgDescriptionLink;
		
	private String deadline;
	
	public Post toPost() {
		Job job = new Job();
		Post post = new Post();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate deadlineDate = LocalDate.parse(deadline, formatter);
		
		String username = SecurityContextHolder
							.getContext()
							.getAuthentication()
							.getName();

		// User user = userRepository.findByUsername(username);
		
		job.setTitle(title);
		job.setDescription(description);
		job.setImgDescriptionLink(imgDescriptionLink);
		job.setDeadline(deadlineDate);
		job.setCompanyWebsite(companyWebsite);
		
		// post.setUser(user);		
		post.setJob(job);
		post.setLikes(0);
		post.setPostTime(LocalDateTime.now());
		
		return post;
	}

	public UserRepository getUserRepository() {
		return userRepository;
	}

	public void setUserRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCompanyWebsite() {
		return companyWebsite;
	}

	public void setCompanyWebsite(String companyWebsite) {
		this.companyWebsite = companyWebsite;
	}

	public String getImgDescriptionLink() {
		return imgDescriptionLink;
	}

	public void setImgDescriptionLink(String imgDescriptionLink) {
		this.imgDescriptionLink = imgDescriptionLink;
	}

	public String getDeadline() {
		return deadline;
	}

	public void setDeadline(String deadline) {
		this.deadline = deadline;
	}
	
}

package com.fernanda.wideond.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fernanda.wideond.entities.Job;
import com.fernanda.wideond.repositories.JobRepository;

@Service
public class JobService {

	@Autowired
	private JobRepository repository;
	
	public List<Job> findAllByUser(String username) {
		List<Job> jobs = 
				repository
					.findAll()
					.stream()
					.filter(job -> job.getUserDetails().getUser().getUsername().equals(username))
					.collect(Collectors.toList());
		
		return jobs;
	}
	
}

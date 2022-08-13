package com.fernanda.wideond.services;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fernanda.wideond.entities.Job;
import com.fernanda.wideond.entities.profiles.CompanyDetails;
import com.fernanda.wideond.repositories.CompanyDetailsRepository;
import com.fernanda.wideond.repositories.UserRepository;
import com.fernanda.wideond.repositories.CompanyDetailsRepository;
import com.fernanda.wideond.services.exceptions.DatabaseException;
import com.fernanda.wideond.services.exceptions.ResourceNotFoundException;

@Service
public class CompanyDetailsService {

	@Autowired
	private CompanyDetailsRepository companyDetailsRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	public List<CompanyDetails> findAll( ) {
		List<CompanyDetails> profiles = companyDetailsRepository.findAll();
		return profiles;
	}
	
	public CompanyDetails findByUsername(String username) {
		CompanyDetails company = userRepository.findByUsername(username).getCompanyDetails();
		return company;
	}
	
	public CompanyDetails save(CompanyDetails company) {
		CompanyDetails feedback = companyDetailsRepository.save(company);
		return feedback;
	}

//	public CompanyDetails update(String username, CompanyDetails sender) {
//		CompanyDetails origin;
//
//		try {
//			origin = companyDetailsRepository.findById(username).get();
//			updateData(origin, sender);
//		} catch(NoSuchElementException exception) {
//			throw new DatabaseException(username);
//		}
//		
//		return origin;			
//	}
	
}

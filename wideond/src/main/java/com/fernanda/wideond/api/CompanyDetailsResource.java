package com.fernanda.wideond.api;

import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fernanda.wideond.entities.profiles.CompanyDetails;
import com.fernanda.wideond.services.CompanyDetailsService;
import com.fernanda.wideond.services.exceptions.DatabaseException;
import com.fernanda.wideond.services.exceptions.ResourceNotFoundException;

@RestController
@RequestMapping(value = "/companies")
public class CompanyDetailsResource {

	@Autowired
	private CompanyDetailsService service;
	
	@GetMapping(value = "/profiles")
	public ResponseEntity<List<CompanyDetails>> findAll() {
		List<CompanyDetails> profiles = service.findAll();
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		
		return ResponseEntity.ok(profiles);
	}

	@GetMapping(value = "/profile/{username}")
	public ResponseEntity<CompanyDetails> findByUsername(@PathVariable String username) {
		CompanyDetails profile = service.findByUsername(username);
		
		if(profile == null) ResponseEntity.badRequest().build();
		
		return ResponseEntity.ok(profile);
	}
	
//	@PostMapping(value = "profile/{username}/newjob")
//	public ResponseEntity<CompanyDetails> offerJob(@PathVariable String username, @RequestBody Job job) {
//		CompanyDetails profile = service.addJob(username, job);
//		return ResponseEntity.ok(profile);
//	}
	
	@PostMapping(value = "/register")
	public CompanyDetails insert(@RequestBody CompanyDetails company) {
		CompanyDetails feedback = service.save(company);
		return feedback;
	}
	
//	@DeleteMapping(value = "/profile/delete/{username}")
//	public ResponseEntity<CompanyDetails> remove(@PathVariable String username) {
//		try {
//			service.delete(username);
//			return ResponseEntity.ok().build();
//		} catch( DatabaseException | ResourceNotFoundException excep ) {
//			return ResponseEntity.badRequest().build();
//		}
//	}

}

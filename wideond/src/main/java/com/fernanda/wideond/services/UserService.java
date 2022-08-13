package com.fernanda.wideond.services;

import java.util.List;
import java.util.NoSuchElementException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.fernanda.wideond.dto.BasicRegisterForm;
import com.fernanda.wideond.dto.UserDetailsData;
import com.fernanda.wideond.entities.enums.Role;
import com.fernanda.wideond.entities.profiles.Authority;
import com.fernanda.wideond.entities.profiles.User;
import com.fernanda.wideond.repositories.AuthorityRepository;
import com.fernanda.wideond.repositories.CompanyDetailsRepository;
import com.fernanda.wideond.repositories.UserDetailsRepository;
import com.fernanda.wideond.repositories.UserRepository;
import com.fernanda.wideond.services.exceptions.UserAlreadyExistsException;

@Service("userService")
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private AuthorityRepository authorityRepository;
	
	@Autowired
	private UserDetailsRepository userDetailsRepository;
	
	@Autowired
	private CompanyDetailsRepository companyDetailsRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public boolean checkIfUserAlreadyExists(String username) {
		return userRepository.findById(username).isPresent();
	}
	
	private void encodePassword(User userEntity) {
		userEntity.setPassword(passwordEncoder.encode(userEntity.getPassword()));
	}
	
	public List<User> findAll() {
		List<User> profiles = userRepository.findAll();
		return profiles;
	}
	
	public User findUser(String username) {
		User user = userRepository.findById(username).get();
		return user;
	}
	
	public void register(BasicRegisterForm basicForm) throws UserAlreadyExistsException {// recebe um formulário básico e ela pode emitir um erro de usuário já cadastrado. 
		
		if(checkIfUserAlreadyExists(basicForm.getUsername())) 	
			throw new UserAlreadyExistsException("User already exists for this username");
		
		User userEntity = basicForm.toUser(); // criando o usuário com os dados dos usuários. 
		
		encodePassword(userEntity); // criptografa senha. 
		userRepository.save(userEntity); // salvo o usuário. 

		Authority authority = new Authority(); // cria a autoridade adequado baseada no formulário (user ou company). 
		authority.setUsername(userEntity.getUsername());
		authority.setAutority(userEntity.getRole().toString());
		
		authorityRepository.save(authority); // salva a autoridade construida. 
	}
	
	public void updateDetails(String username, @Valid UserDetailsData userDetailsData) { 

		if(!checkIfUserAlreadyExists(username)) {
			return;
		}
		
		User user = userRepository.findByUsername(username);
		
	}

	public User findByUsername(String username) {
		try {
			List<User> profiles = userRepository.findAll();
			User profile = profiles.stream() // in stream mode
					.filter(p -> p.getUsername().equals(username)) // filtered by username
					.findAny() // catch the first
					.orElseThrow(); // if there is not a first, return null

			return profile;
		} catch (NoSuchElementException exception) {
			throw exception; // TODO new ResourceNotFoundException(username);
		}
	}


}

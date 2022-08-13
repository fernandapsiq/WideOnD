package com.fernanda.wideond.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.springframework.beans.factory.annotation.Autowired;

import com.fernanda.wideond.entities.enums.Role;
import com.fernanda.wideond.entities.profiles.User;
import com.fernanda.wideond.repositories.UserRepository;

public class BasicRegisterForm {
	
	@Autowired // campos minimos necessário para criação do usuário. 
	private UserRepository userRepository; // A thymeleaf usa essa classe para criar um usuário com essas caracteristica. 
	
	@NotEmpty (message = "the username cannot be empty")
	private String username;
	
	@NotEmpty (message = "the email cannot be empty")
	@Email(message = "Must be a valid email")
	private String email;

	@NotEmpty (message = "the first name cannot be empty")
	private String password;
	
	@NotEmpty (message = "the phone cannot be empty")
	private String phone;
	
	@NotEmpty
	private String role;
	
	public User toUser() {
		User user = new User();
		user.setEmail(email);
		user.setUsername(username);
		user.setPassword(password);
		user.setPhone(phone);
		user.setRole(role.equalsIgnoreCase("user") ? Role.USER : Role.COMPANY);
		user.setEnabled(true);
		return user;
	}

	public UserRepository getUserRepository() {
		return userRepository;
	}

	public void setUserRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
}

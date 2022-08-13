package com.fernanda.wideond.entities.profiles;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "authorities")
public class Authority {
	
	@Id
	private String username;
	
	private String authority;

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUsername() {
		return username;
	}

	public String getAutority() {
		return authority;
	}

	public void setAutority(String autority) {
		this.authority = autority;
	}
	
}

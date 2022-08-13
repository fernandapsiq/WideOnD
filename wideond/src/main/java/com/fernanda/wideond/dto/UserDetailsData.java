package com.fernanda.wideond.dto;

import com.fernanda.wideond.entities.profiles.UserDetails;

public class UserDetailsData {


	private String firstName;

	private String lastName;

	private String about;

	private Integer age;

	private String location;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAbout() {
		return about;
	}

	public void setAbout(String about) {
		this.about = about;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public UserDetails toUserDetails() {
		UserDetails details = new UserDetails();
		
		details.setFirstName(firstName);
		details.setLastName(lastName);
		details.setAbout(about);
		details.setAge(age);
		details.setLocation(location);

		return details;
	}

}

package com.fernanda.wideond.entities.profiles;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fernanda.wideond.entities.Comment;
import com.fernanda.wideond.entities.Job;
import com.fernanda.wideond.entities.Skill;

@Entity
@Table(name = "user_details")
public class UserDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String firstName;
	
	private String lastName;
	
	private String about;
	
	private Integer age;
	
	private String location;
	
	@OneToOne(optional = true, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name="user_id")
	private User user;
	
	// trabalhos deste usuário
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "userDetails", fetch = FetchType.LAZY)
	private List<Job> jobs; 
	
	// trabalhos deste usuário
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "userDetails", fetch = FetchType.LAZY)
	private List<Comment> comments; 
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinTable(name = "user_skills", 
		joinColumns = { @JoinColumn(name = "user_id") }, 
		inverseJoinColumns = {@JoinColumn(name = "skill_id") })
	private Set<Skill> skills = new HashSet<>();

	// TODO
	//	@OneToMany(cascade = CascadeType.ALL, mappedBy = "user",
	//	fetch = FetchType.LAZY)
	// private List<Project> projects;
	
	public void addSkill(Skill skill) { // Faz com que o usuário receba uma skill, e uma skill receba um usuário sem repetição.
		this.skills.add(skill);
		skill.getUserDetails().add(this);
	} // essa função faz com que, não seja possivel eu adicionar a mesma skill para o mesmo usuário, 
	
	public void removeSkill(String name) { // Remove a skil pesquisando pelo nome da skill. 
		Skill skill = this
						.skills
						.stream()
						.filter(s -> s.getName().equals(name))
						.findFirst()
						.orElse(null);
		
		if(skill != null) {
			this.skills.remove(skill);
			skill.getUserDetails().remove(this);
		}
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Job> getJobs() {
		return jobs;
	}

	public void setJobs(List<Job> jobs) {
		this.jobs = jobs;
	}

	public Set<Skill> getSkills() {
		return skills;
	}

	public void setSkills(Set<Skill> skills) {
		this.skills = skills;
	}
	
}

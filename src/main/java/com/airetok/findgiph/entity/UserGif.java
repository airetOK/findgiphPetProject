package com.airetok.findgiph.entity;

import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import com.airetok.findgiph.validation.UniqueValue;

@Entity
@Table(name = "user_gif")
@UniqueValue
public class UserGif {
	
	public UserGif() {
		
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotNull
	@Size(min = 6)
	private String username;
	
	private String urls;
	
	@NotNull
	@Size(min = 6)
	private String password;
	
	private String authority;
	
	private String enabled;
	
	@Column(name = "first_name")
	@NotNull
	private String firstName;
	
	@Column(name = "last_name")
	@NotNull
	private String lastName;
	
	
	@NotNull
	@Email
	private String email;
	
	@Column(name = "date_of_birth")
	@NotNull
	private Date dateOfBirth;
	
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUrls() {
		return urls;
	}

	public void setUrls(String urls) {
		this.urls = urls;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

	public String getEnabled() {
		return enabled;
	}

	public void setEnabled(String enabled) {
		this.enabled = enabled;
	}

	@Override
	public String toString() {
		return "UserGif [id=" + id + ", username=" + username + ", urls=" + urls + ", password=" + password
				+ ", authority=" + authority + ", enabled=" + enabled + ", firstName=" + firstName + ", lastName="
				+ lastName + ", email=" + email + ", dateOfBirth=" + dateOfBirth + "]";
	}

	
	
	
	
	

}

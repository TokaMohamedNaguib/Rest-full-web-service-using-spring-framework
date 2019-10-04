package com.restfull.web.services.idealwaves.task.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "Users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull(message = " your first name cannot be null value")
	@Size(min = 1, max = 8, message = "your first name can not exceed 8 chracters")
	@Column(name = "first_name")
	private String firstName;

	@NotNull(message = " your lastname cannot be null value")
	@Size(min = 1, max = 8, message = "your last name can not exceed 8 chracters")
	@Column(name = "last_name")
	private String lastName;

	@NotNull(message = "email cannot be null")
	@Email
	@Column(name = "email")
	private String email;

	@NotNull(message = "password cannot be null value")
	@Size(min = 5, max = 8, message = "password must be between 5 to 8 charater")
	@Column(name = "password")
	private String password;

	public Long getId() {
		return id;
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

}

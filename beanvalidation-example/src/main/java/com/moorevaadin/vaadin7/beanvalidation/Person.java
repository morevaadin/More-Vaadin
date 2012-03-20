package com.moorevaadin.vaadin7.beanvalidation;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;

public class Person {

	private long id;

	private Gender gender;

	@Size(max = 250)
	@NotNull
	private String firstName;

	@Size(max = 250)
	@NotNull
	private String lastName;

	@Size(max = 250)
	@Email
	private String email;

	private Date birthdate;

	public long getId() {

		return id;
	}

	public Gender getGender() {

		return gender;
	}

	public String getFirstName() {

		return firstName;
	}

	public String getLastName() {

		return lastName;
	}

	public String getEmail() {

		return email;
	}

	public Date getBirthdate() {

		return birthdate;
	}

	public void setId(long id) {

		this.id = id;
	}

	public void setGender(Gender gender) {

		this.gender = gender;
	}

	public void setFirstName(String firstName) {

		this.firstName = firstName;
	}

	public void setLastName(String lastName) {

		this.lastName = lastName;
	}

	public void setEmail(String email) {

		this.email = email;
	}

	public void setBirthdate(Date birthdate) {

		this.birthdate = birthdate;
	}
}

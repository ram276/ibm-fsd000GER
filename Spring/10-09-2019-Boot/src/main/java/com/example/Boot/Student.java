package com.example.Boot;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "student2")

public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	// @NonNull
	@Column(name = "id")
	private int id;
	@Column(name = "fname")
	// @Range(min = 5, max = 10)
	private String firstName;
	// @Range(min = 5, max = 10)
	@Column(name = "lname")
	private String lastName;
	// @javax.validation.constraints.Email
	@Column(name = "email")
	private String email;

	public Student(String firstName, String lastName, String email) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Student() {
		super();
	}

}

package com.gcu.model;

// import jakarta.persistence.Entity;
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.GenerationType;
// import jakarta.persistence.Id;
// import jakarta.persistence.Table;

// @Entity
// @Table(name = "users")
public class User {

	// @Id
	// @GeneratedValue(strategy = GenerationType.IDENTITY)
	// private Long id;
	private String firstName;
	private String lastName;
	private String email;
	private String password;

	public User() {
	}

	// public Long getId() {
	// return this.id;
	// }

	// public void setId(Long id) {
	// this.id = id;
	// }

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	// Constructors, getters, setters
}
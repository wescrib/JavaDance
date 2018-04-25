package com.scribnerw.models.User;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Transient;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public abstract class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	protected int id;
	
	@Column(name="first_name")
	@Size(min=1, max=255, message="First name must be at least one character")
	protected String firstName;
	
	@Column(name="last_name")
	@Size(min=1, max=255, message="Last name must be at least one character")
	protected String lastName;
	
	@Email(message="Invalid email format")
	protected String email;
	
	@Size(min=8, max=255, message="Password must be at least 8 characters")
	protected String password;
	
	@Transient
	@Column(name="conf_pw")
	@Size(min=8, max=255, message="Password confirmation does not match")
	protected String confirmPw;
	
	@DateTimeFormat(pattern="MM/dd/yyyy")
	protected Date birthday;
	
	@Column(name="created_at")
	@DateTimeFormat(pattern="MM/dd/yyyy HH:mm:ss")
	protected Date createdAt;
	
	@Column(name="updated_at")
	@DateTimeFormat(pattern="MM/dd/yyyy HH:mm:ss")
	protected Date updatedAt;
	
	protected String errors;
	
	public String getErrors() {
		return errors;
	}

	public void setErrors(String error) {
		this.errors = error;
	}

	@PrePersist
	public void onCreate() {
		this.createdAt = new Date();
	}
	
	@PreUpdate
	public void onUpdate() {
		this.updatedAt = new Date();
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

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}


	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", birthday=" + birthday + "]";
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

}

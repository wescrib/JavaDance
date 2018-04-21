package com.scribnerw.models.User;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="studenttab")
public class Student extends User {
	public Student() {
		super();
		this.createdAt = new Date();
		this.updatedAt = new Date();
	}
}

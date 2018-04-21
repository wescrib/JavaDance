package com.scribnerw.models.User;

import java.util.Date;

import javax.persistence.Entity;

@Entity
public class Instructor extends User {
	
	private String fun;
	
	public Instructor() {
		this.createdAt = new Date();
		this.updatedAt = new Date();
	}

	public String getFun() {
		return fun;
	}

	public void setFun(String fun) {
		this.fun = fun;
	}
	
}

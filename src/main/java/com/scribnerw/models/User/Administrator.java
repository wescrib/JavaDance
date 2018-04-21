package com.scribnerw.models.User;

import java.util.Date;

import javax.persistence.Entity;

@Entity
public class Administrator extends User {
	
	public Administrator() {
		this.createdAt = new Date();
		this.updatedAt = new Date();
	}
	
}

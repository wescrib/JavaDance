package com.scribnerw.models.Styles;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name="style")
public class Style {

	@Id
	@GeneratedValue
	private long id;
	
	@Size(min=1, max=255, message="Name must be between 1 - 255 characters")
	private String name;
	
	@Size(min=1, max=10000, message="Name must be between 1 - 10000 characters")
	private String description;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String desc) {
		this.description = desc;
	}
}

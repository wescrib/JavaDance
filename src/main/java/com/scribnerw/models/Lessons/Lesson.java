package com.scribnerw.models.Lessons;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Lesson {
	@Id
	@GeneratedValue
	private int id;
	
	@Size(min=2, max=100, message="Dance style must be between 2 and 100 characters")
	private String style;
	
	@Max(20)
	private int capacity;
	
	@DateTimeFormat(pattern="MM-dd-yyyy HH:mm:ss")
	private Date lessonDate;
	
	private boolean groupClass=false;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStyle() {
		return style;
	}

	public void setStyle(String style) {
		this.style = style;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public Date getLessonDate() {
		return lessonDate;
	}

	public void setLessonDate(Date lessonDate) {
		this.lessonDate = lessonDate;
	}

	@Override
	public String toString() {
		return "Lesson [id=" + id + ", style=" + style + ", capacity=" + capacity + ", lessonDate=" + lessonDate + "]";
	}

	public boolean isGroupClass() {
		return groupClass;
	}

	public void setGroupClass(boolean groupClass) {
		this.groupClass = groupClass;
	}
	
	

}

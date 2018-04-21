package com.scribnerw.service;

import java.util.List;

import com.scribnerw.models.User.*;

public interface UserServiceInterface {

	Student saveUser(Student student);
	
	Student updateUser(Student student);
	
	void deleteUser(Student student);
	
	Student getUserById(int id);
	
	List<Student> getAllUsers();
}

package com.scribnerw.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.scribnerw.models.User.Student;
import com.scribnerw.repos.StudentRepo;

public class UserServiceImpl implements UserServiceInterface {
	
	@Autowired
	private StudentRepo repo;

	@Override
	public Student saveUser(Student user) {
		return repo.save(user);
	}

	@Override
	public Student updateUser(Student user) {
		return repo.save(user);
	}

	@Override
	public void deleteUser(Student user) {
		repo.delete(user);
		
	}

	@Override
	public Student getUserById(int id) {
		return repo.findOne(id);
	}

	@Override
	public List<Student> getAllUsers() {
		return null;
	}
	
	

}

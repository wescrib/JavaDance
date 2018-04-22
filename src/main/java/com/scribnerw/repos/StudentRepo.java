package com.scribnerw.repos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.scribnerw.models.User.*;

@Repository
public interface StudentRepo extends CrudRepository<Student, Integer>{

	Student findByEmail(String email);
	
}

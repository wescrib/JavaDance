package com.scribnerw.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.scribnerw.models.User.*;

@Repository
public interface UserRepo extends JpaRepository<Student, Integer>{

	
}

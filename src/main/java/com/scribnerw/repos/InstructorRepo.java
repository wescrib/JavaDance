package com.scribnerw.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.scribnerw.models.User.Instructor;

public interface InstructorRepo extends JpaRepository<Instructor, Integer> {

}

package com.scribnerw.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.scribnerw.models.User.Administrator;

public interface AdminRepo extends JpaRepository<Administrator, Integer> {

}

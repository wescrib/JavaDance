package com.scribnerw.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.scribnerw.models.User.User;

public interface UserRepo extends JpaRepository <User, Integer>{
}

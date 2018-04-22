package com.scribnerw.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.scribnerw.models.Styles.Style;

public interface StyleRepo extends JpaRepository<Style, Integer> {

}

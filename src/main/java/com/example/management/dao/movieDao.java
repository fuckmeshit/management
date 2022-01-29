package com.example.management.dao;

import com.example.management.entity.Movie;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

public interface movieDao  extends JpaRepository<Movie,Integer> {

    Page<Movie> findAllMovie();
}

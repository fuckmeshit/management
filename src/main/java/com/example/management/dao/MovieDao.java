package com.example.management.dao;

import com.example.management.entity.Movie;
import com.example.management.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MovieDao extends JpaRepository<Movie,Integer> {
    /**
     * 这里Query的内容应该是返回一部分的内容，具体的记不清了
     *
     */
}

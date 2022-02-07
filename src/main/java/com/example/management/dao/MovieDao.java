package com.example.management.dao;

import com.example.management.entity.Movie;
import com.example.management.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MovieDao extends JpaRepository<Movie,Integer> {
    /**
     * 这里Query的内容应该是返回一部分的内容，具体的记不清了
     *
     */
    @Query("select m.id,m.mvname,m.mvinformation,m.mvtype from Movie m")
    Page<Movie> findList(Pageable pageable);
    List<Movie> findByMvname(String mvname);
}

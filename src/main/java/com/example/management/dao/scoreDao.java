package com.example.management.dao;

import com.example.management.entity.score;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface scoreDao extends JpaRepository<score,String> {
    @Query("select s from score s ")
    Page<score> findlist(Pageable pageable);

    @Transactional
    @Modifying
    int deleteById(int id);
}

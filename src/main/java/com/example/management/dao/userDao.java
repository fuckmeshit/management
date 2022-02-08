package com.example.management.dao;

import com.example.management.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface userDao extends JpaRepository<User,Integer> {
@Query("select u from User u")
Page<User> findList(Pageable pageable);

    /**
     *
     *
     *
     */
    List<User> findByUsername(String username);
    User findById(int id);

}

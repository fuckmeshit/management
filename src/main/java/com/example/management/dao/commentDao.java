package com.example.management.dao;

import com.example.management.entity.User;
import com.example.management.entity.comment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface commentDao extends JpaRepository<comment,String> {
    @Query("select c from comment c")
    Page<comment> findList(Pageable pageable);
    @Modifying
    @Query("update comment c set c.ischecked=?1 where c.id=?2")
    int checkedcomfirm(String checked,int id);
    int deleteById(int id);
}

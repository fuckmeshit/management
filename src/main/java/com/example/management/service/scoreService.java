package com.example.management.service;

import com.example.management.dao.scoreDao;
import com.example.management.entity.score;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.List;

@Service
public class scoreService {
    @Autowired
    private scoreDao scoredao;
    public List<score> getlist(int page,int size){
        PageRequest pageable=PageRequest.of(page,size);
        List<score> list=scoredao.findlist(pageable).getContent();
        return list;
    }
    public int deletescore(int id){
        return scoredao.deleteById(id);
    }
}

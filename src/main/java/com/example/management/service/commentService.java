package com.example.management.service;

import com.example.management.dao.commentDao;
import com.example.management.entity.comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Transactional
@Service
public class commentService {
    @Autowired
    private commentDao commentdao;
    public List<comment> commentList(int page, int size){
        PageRequest pageable=PageRequest.of(page,size);
        List<comment> movielist=commentdao.findList(pageable).getContent();
        return movielist;
    }
    public int updatecomment(int id) {
        int i = commentdao.checkedcomfirm("checked", id);
        return i;
    }
    public int deletecomment(int id){
        int i=commentdao.deleteById(id);
        return i;
    }

}

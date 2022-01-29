package com.example.management.service;

import com.example.management.dao.userDao;
import com.example.management.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.util.List;
@Service
public class userService {
    @Autowired
    private userDao userdao;
    public List<User> userList(int page, int size){
        PageRequest pageable=PageRequest.of(page,size);
        List<User> pageList=userdao.findList(pageable).getContent();
        return pageList;
    }

}

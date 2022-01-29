package com.example.management.service;

import com.example.management.dao.userDao;
import com.example.management.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
@Service
public class userService {
    @Autowired
    private userDao userdao;
    public List<User> userList(){
        return userdao.findList();
    }

}

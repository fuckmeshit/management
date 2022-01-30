package com.example.management.service;

import com.example.management.dao.MovieDao;
import com.example.management.dao.userDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class movieService {
    @Autowired
    userDao userdao;
    public void findUser(String username){
        userdao.findByUsername(username);

    }
}

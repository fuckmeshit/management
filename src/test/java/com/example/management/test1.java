package com.example.management;

import com.example.management.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.example.management.service.userService;


import java.util.Iterator;
import java.util.List;

@SpringBootTest
public class test1 {
    @Autowired
    userService userservice;
    @Test
    public void test1_1(){
        List<User> a1=userservice.userList();
        Iterator it=a1.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }
    }

}

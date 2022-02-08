package com.example.management.controller;

import com.example.management.entity.User;
import com.example.management.service.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.relational.core.sql.In;
import org.springframework.web.bind.annotation.*;
import com.example.management.service.userService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class userController {
    @Autowired
    private userService userservice;
    @CrossOrigin
    @GetMapping("/user/{page}/{size}")
    public List<User> list(
            @PathVariable("page") Integer page,
            @PathVariable("size") Integer size
    ){
       return userservice.userList(page,size);
    }
    @CrossOrigin
    @GetMapping("/usersearch/{username}")
    public List<User> getuser(
            @PathVariable("username") String username
    ) {
        /**
         * 这里用来写查找用户返回的数据的内容
         * 先不写
         */
        return userservice.findUser(username);
    }
    @CrossOrigin
    @GetMapping("/searchuser/{userId}")
    public User findupDateUser(
            @PathVariable("userId")int userid
            ){
        return userservice.findUpdateUser(userid);
    }
    @CrossOrigin
    @PostMapping("/updateuser")
    @ResponseBody
    public Result UpdateUser(
            @RequestBody User requestUser
    ){
        User updUser=new User();
        String username=requestUser.getUsername();
        String password=requestUser.getPassword();
        String email=requestUser.getEmail();
        int id=requestUser.getId();
        updUser.setEmail(email);
        updUser.setUsername(username);
        updUser.setId(id);
        updUser.setPassword(password);
        int result= userservice.updateuser(updUser);
        if (result==1){
            return new Result(200);
        }else {
            return new Result(500);
        }
    }
    @CrossOrigin
    @GetMapping("/userdelete/{id}")
    public Result deleteUser(
            @PathVariable("id")int id
    ){
        int result= userservice.deleteuser(id);
        if (result==1){
            return new Result(200);
        }else {
            return new Result(500);
        }
    }
}

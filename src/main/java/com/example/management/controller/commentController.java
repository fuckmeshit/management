package com.example.management.controller;

import com.example.management.entity.comment;
import com.example.management.service.Result;
import com.example.management.service.commentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class commentController {
    @Autowired
    commentService commentservice;
    @CrossOrigin
    @GetMapping("/commentmanage/{page}/{size}")
    public List<comment> commentList(
            @PathVariable("page")int page,
            @PathVariable("size")int size
    ){
        return commentservice.commentList(page,size);
    }
    @CrossOrigin
    @GetMapping("/commentchecked/{id}")
    public Result updatecomment(
            @PathVariable("id")int id
            ){
        int result= commentservice.updatecomment(id);
        if (result==1){
            return new Result(200);
        }else {
            return new Result(500);
        }
    }
    @CrossOrigin
    @RequestMapping("/commentdelete/{id}")
    public Result deletecomment(
            @PathVariable("id")int id
    ){
        int result=commentservice.deletecomment(id);
        if (result==1){
            return new Result(200);
        }else {
            return new Result(500);
        }
    }
}

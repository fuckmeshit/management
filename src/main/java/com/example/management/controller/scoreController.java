package com.example.management.controller;

import com.example.management.entity.score;
import com.example.management.service.Result;
import com.example.management.service.scoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class scoreController {
    @Autowired
    scoreService scoreservice;
    @CrossOrigin
    @RequestMapping("/scoremanage/{page}/{size}")
    public List<score> findlist(
            @PathVariable("page")int page,
            @PathVariable("size")int size
    ){
        return scoreservice.getlist(page,size);
    }
    @CrossOrigin
    @RequestMapping("/scoredelete/{id}")
    public Result deletescore(
            @PathVariable("id")int id
    ){
        int i=scoreservice.deletescore(id);
        if (i!=0)
            return new Result(200);
        else
            return new Result(500);
    }
}

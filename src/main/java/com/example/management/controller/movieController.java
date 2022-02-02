package com.example.management.controller;

import com.example.management.entity.Movie;
import com.example.management.entity.User;
import com.example.management.service.movieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.relational.core.sql.In;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * @author 25097
 * 这里用于将电影信息从数据库提出来
 * @Date 2022/2/2
 */
@RestController
public class movieController {
    @Autowired
    movieService movieService;
    @CrossOrigin
    @RequestMapping("/api/movie/{page}/{size}")
    public List<Object> getMovies(
            @PathVariable("page")Integer page,
            @PathVariable("size")Integer size
            ){
        return movieService.findList(page,size);

    }
}

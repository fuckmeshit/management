package com.example.management.controller;

import com.example.management.entity.Movie;
import com.example.management.entity.User;
import com.example.management.entity.comment;
import com.example.management.service.Result;
import com.example.management.service.movieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.relational.core.sql.In;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Column;
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

    @CrossOrigin
    @RequestMapping("/api/moviesearch/{mvname}")
    public List<Movie> getMovie(
            @PathVariable("mvname")String mvname
    ){
        return movieService.findMovie(mvname);
    }
    @CrossOrigin
    @RequestMapping("/api/searchmvid/{mvid}")
    public Movie findMovieById(
            @PathVariable("mvid")int id
    ){
        return movieService.findMovieById(id);
    }
    @CrossOrigin
    @PostMapping("/api/updatemovie")
    @ResponseBody
    public Result UpdateUser(
            @RequestBody Movie requestMovie
    ){
        Movie movie=new Movie();
        int id=requestMovie.getId();
        String mvname=requestMovie.getMvname();
        String mvinformation=requestMovie.getMvinformation();
        String mvtype=requestMovie.getMvtype();
        movie.setId(id);
        movie.setMvname(mvname);
        movie.setMvtype(mvtype);
        movie.setMvinformation(mvinformation);
        int result= movieService.updatemovie(movie);
        if (result==1){
            return new Result(200);
        }else {
            return new Result(500);
        }
    }
    @CrossOrigin
    @GetMapping("/api/moviedelete/{id}")
    public Result deleteMovie(
            @PathVariable("id")int id
    ){
        int result= movieService.deletemovie(id);
        if (result==1){
            return new Result(200);
        }else {
            return new Result(500);
        }
    }
}

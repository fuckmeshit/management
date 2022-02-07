package com.example.management.service;

import com.example.management.dao.MovieDao;
import com.example.management.dao.userDao;
import com.example.management.entity.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class movieService {
    @Autowired
    private MovieDao movieDao;
    public List<Object> findList(int page, int size){
        PageRequest pageable=PageRequest.of(page,size);
        List<Movie> movieList=movieDao.findList(pageable).getContent();
        List<Object> arrayList = null;
        arrayList=new ArrayList<>();
        for (Object obj:movieList){
            Map<String,Object>map=new HashMap<>();
            Object[] arr=(Object[]) obj;
            map.put("id",arr[0]);
            map.put("mvname",arr[1]);
            map.put("mvinformation",arr[2]);
            map.put("mvtype",arr[3]);
            arrayList.add(map);
        }
        return arrayList;
    }
    public List<Movie> findMovie(String mvname){
        return movieDao.findByMvname(mvname);
    }
}

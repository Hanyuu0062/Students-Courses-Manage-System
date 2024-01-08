package com.hanyuu.springbootlearn.service;


import com.hanyuu.springbootlearn.entity.Course;
import com.hanyuu.springbootlearn.entity.PageBean;
import com.hanyuu.springbootlearn.entity.Student;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

public interface CourseService {
    public PageBean<Course> Get(Integer pageNum, Integer pageSize, Integer id, String name);
    public Map<Integer, String> getMap();
}

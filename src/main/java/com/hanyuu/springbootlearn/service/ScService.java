package com.hanyuu.springbootlearn.service;

import com.hanyuu.springbootlearn.entity.Course;
import com.hanyuu.springbootlearn.entity.PageBean;
import com.hanyuu.springbootlearn.entity.Sc;
import org.springframework.web.bind.annotation.RequestParam;

public interface ScService {
    public PageBean<Sc> get(Integer pageNum, Integer pageSize, Long sid, Integer cid);
}

package com.hanyuu.springbootlearn.service;

import com.hanyuu.springbootlearn.entity.PageBean;
import com.hanyuu.springbootlearn.entity.Student;

import java.util.List;
import java.util.Map;

public interface StuService {
    public PageBean<Student> stuGet(Integer pageNum, Integer pageSize, Long  id, String name);
    public void delStu(Long id);
    public Map<Long,String> getMap();
}

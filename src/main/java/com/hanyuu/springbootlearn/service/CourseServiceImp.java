package com.hanyuu.springbootlearn.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.hanyuu.springbootlearn.entity.Course;
import com.hanyuu.springbootlearn.entity.PageBean;
import com.hanyuu.springbootlearn.entity.Student;
import com.hanyuu.springbootlearn.mapper.CourseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CourseServiceImp implements CourseService{
    @Autowired
    CourseMapper courseMapper;

    @Override
    public PageBean<Course> Get(Integer pageNum, Integer pageSize, Integer id, String name) {
        PageBean<Course> pb = new PageBean<>();

        //开启分页查询
        PageHelper.startPage(pageNum, pageSize);

        // 调用mapper层
        List<Course> cList = courseMapper.get(id, name);

        // 用page类获取结果
        Page<Course> page = (Page<Course>) cList;
        pb.setList(page.getResult());
        pb.setTotal(page.getTotal());

        return pb;
    }


    public Map<Integer, String> getMap() {
        List<Course> list = courseMapper.get(null, null);
        Map<Integer, String> res = new HashMap<>();
        for (Course e : list) {
            res.put(e.getId(), e.getName());
        }
        return res;
    }
}

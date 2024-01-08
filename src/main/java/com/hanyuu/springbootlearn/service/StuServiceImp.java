package com.hanyuu.springbootlearn.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.hanyuu.springbootlearn.entity.PageBean;
import com.hanyuu.springbootlearn.entity.Student;
import com.hanyuu.springbootlearn.mapper.StuMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class StuServiceImp implements StuService {
    @Autowired
    private StuMapper stuMapper;

    public PageBean<Student> stuGet(Integer pageNum, Integer pageSize, Long id, String name) {
        PageBean<Student> pb = new PageBean<>();

        //开启分页查询
        PageHelper.startPage(pageNum, pageSize);

        // 调用mapper层
        List stuList = stuMapper.getStu(id, name);

        // 用page类获取结果
        Page<Student> page = (Page<Student>) stuList;
        pb.setList(page.getResult());
        pb.setTotal(page.getTotal());

        return pb;
    }

    @Override
    public Map<Long, String> getMap() {
        List<Student> list = stuMapper.getStu(null, null);
        Map<Long, String> res = new HashMap<>();
        for (Student stu : list) {
            res.put(stu.getId(), stu.getName());
        }
        return res;
    }

    public void delStu(Long id) {
        stuMapper.del(id);
    }
}

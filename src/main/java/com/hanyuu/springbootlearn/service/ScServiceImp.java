package com.hanyuu.springbootlearn.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.hanyuu.springbootlearn.entity.PageBean;
import com.hanyuu.springbootlearn.entity.Sc;
import com.hanyuu.springbootlearn.entity.Student;
import com.hanyuu.springbootlearn.mapper.ScMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
public class ScServiceImp implements ScService {
    @Autowired
    ScMapper scMapper;

    @Override
    public PageBean<Sc> get(Integer pageNum, Integer pageSize, Long sid, Integer cid) {
        PageHelper.startPage(pageNum, pageSize);
        List<Sc> list = scMapper.get(sid, cid);
        Page<Sc> page = (Page<Sc>) list;
        PageBean<Sc> pb = new PageBean<>();
        pb.setTotal(page.getTotal());
        pb.setList(page.getResult());
        return pb;
    }
}

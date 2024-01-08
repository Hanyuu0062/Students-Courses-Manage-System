package com.hanyuu.springbootlearn.controller;

import com.hanyuu.springbootlearn.entity.PageBean;
import com.hanyuu.springbootlearn.entity.Result;
import com.hanyuu.springbootlearn.entity.Sc;
import com.hanyuu.springbootlearn.entity.Student;
import com.hanyuu.springbootlearn.mapper.ScMapper;
import com.hanyuu.springbootlearn.service.ScService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/sc")
public class ScController {
    @Autowired
    ScService scService;

    @Autowired
    ScMapper scMapper;

    @GetMapping
    public Result<?> get(Integer pageNum, Integer pageSize,
                         @RequestParam(required = false) Long sid,
                         @RequestParam(required = false) Integer cid) {
        PageBean<Sc> res = scService.get(pageNum, pageSize, sid, cid);
        if (res == null) {
            return Result.fail();
        } else {
            return Result.success(res);
        }
    }

    @DeleteMapping
    public Result<?> del(Long sid, Integer cid) {
        scMapper.del(sid, cid);
        return Result.success("删除成功");
    }

    @PostMapping("/add")
    public Result<?> add(@RequestBody Sc sc) {
        scMapper.add(sc);
        return Result.success("增加成功");
    }

    @PostMapping("/edit")
    public Result<?> edit(@RequestBody Sc sc) {
        scMapper.edit(sc);
        return Result.success("编辑成功");
    }
}


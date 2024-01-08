package com.hanyuu.springbootlearn.controller;

import com.hanyuu.springbootlearn.entity.PageBean;
import com.hanyuu.springbootlearn.entity.Result;
import com.hanyuu.springbootlearn.entity.Student;
import com.hanyuu.springbootlearn.mapper.StuMapper;
import com.hanyuu.springbootlearn.service.StuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/student")
public class StuController {
    @Autowired
    StuService stuService;

    @Autowired
    StuMapper stuMapper;

    @GetMapping
    public Result<?> stuGet(Integer pageNum,
                            Integer pageSize,
                            @RequestParam(required = false) Long  id,
                            @RequestParam(required = false) String name) {

        PageBean<Student> pageBean = stuService.stuGet(pageNum, pageSize, id, name);
        if (pageBean == null) {
            return Result.fail("查询失败");
        } else {
            return Result.success(pageBean);
        }
    }

    @DeleteMapping
    public Result<?> delStu(Long id){
        stuService.delStu(id);
        return Result.success("删除成功");
    }

    @PostMapping("/add")
    public Result<?> addStu(@RequestBody Student stu){
        stuMapper.add(stu);
        return Result.success("新增成功");
    }

    @PostMapping("/edit")
    public Result<?> editStu(@RequestBody Student stu){
        stuMapper.update(stu);
        return Result.success("编辑成功");
    }

    @GetMapping("/map")
    public Result<?> getMap(){
        Map<Long, String> map = stuService.getMap();
        return Result.success(map);
    }
}

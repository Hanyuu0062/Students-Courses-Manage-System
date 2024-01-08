package com.hanyuu.springbootlearn.controller;

import com.hanyuu.springbootlearn.entity.Course;
import com.hanyuu.springbootlearn.entity.PageBean;
import com.hanyuu.springbootlearn.entity.Result;
import com.hanyuu.springbootlearn.entity.Student;
import com.hanyuu.springbootlearn.mapper.CourseMapper;
import com.hanyuu.springbootlearn.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/course")
public class CourseController {
    @Autowired
    CourseService courseService;

    @Autowired
    CourseMapper courseMapper;

    @GetMapping
    public Result<?> courseGet(Integer pageNum,
                               Integer pageSize,
                               @RequestParam(required = false) Integer id,
                               @RequestParam(required = false) String name) {

        PageBean<Course> pageBean = courseService.Get(pageNum, pageSize, id, name);
        if (pageBean == null) {
            return Result.fail("查询失败");
        } else {
            return Result.success(pageBean);
        }
    }

    @DeleteMapping
    public Result<?> courseDelete(Integer id){
        courseMapper.del(id);
        return Result.success("删除成功");
    }

    @PostMapping("/add")
    public Result<?> courseAdd(@RequestBody Course c){
        courseMapper.add(c);
        return Result.success("添加成功");
    }

    @PostMapping("/edit")
    public Result<?> courseEdit(@RequestBody Course c){
        courseMapper.update(c);
        return Result.success("修改成功");
    }

    @GetMapping("/map")
    public Result<?> getMap(){
        Map<Integer, String> map = courseService.getMap();
        return Result.success(map);
    }
}

package com.hanyuu.springbootlearn.controller;

import com.hanyuu.springbootlearn.entity.Department;
import com.hanyuu.springbootlearn.entity.Result;
import com.hanyuu.springbootlearn.mapper.DepMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/dep")
public class DepController {
    @Autowired
    DepMapper depMapper;

    @GetMapping
    public Result<?> getDep() {
        List<Department> res = depMapper.getDep();
        return Result.success(res);
    }

}

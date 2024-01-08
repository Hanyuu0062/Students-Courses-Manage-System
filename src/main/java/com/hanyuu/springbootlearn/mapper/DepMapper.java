package com.hanyuu.springbootlearn.mapper;

import com.hanyuu.springbootlearn.entity.Department;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface DepMapper {
    @Select("select * from department")
    public List<Department> getDep();
}

package com.hanyuu.springbootlearn.mapper;

import com.hanyuu.springbootlearn.entity.Course;
import com.hanyuu.springbootlearn.entity.Student;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface CourseMapper {
    public List<Course> get(Integer id, String name);

    @Delete("delete from course where id=#{id}")
    public void del(Integer id);

    @Insert("insert into course(name,teacher,credit) " +
            "values(#{name},#{teacher},#{credit})")
    public void add(Course c);

    @Update("update course "
            + "set name=#{name},teacher=#{teacher},credit=#{credit}"
            + "where id=#{id}")
    public void update(Course c);
}


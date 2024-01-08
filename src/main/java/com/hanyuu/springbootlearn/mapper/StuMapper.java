package com.hanyuu.springbootlearn.mapper;

import com.hanyuu.springbootlearn.entity.Student;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface StuMapper {
    public List<Student> getStu(Long id, String name);

    @Delete("delete from student where student.id=#{id}")
    public void del(Long id);

    @Insert("insert into student value(#{id},#{name},#{sex},#{age},#{dep})")
    public void add(Student stu);

    @Update("update student "
            + "set name=#{name},sex=#{sex},age=#{age},dep=#{dep}"
            + "where id=#{id}")
    public void update(Student stu);
}

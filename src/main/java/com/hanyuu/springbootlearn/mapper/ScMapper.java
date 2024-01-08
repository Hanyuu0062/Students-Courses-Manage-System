package com.hanyuu.springbootlearn.mapper;

import com.hanyuu.springbootlearn.entity.Sc;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface ScMapper {
    public List<Sc> get(Long sid, Integer cid);

    @Insert("insert into Sc(sid,cid,pts)" +
            "value (#{sid},#{cid},#{pts})")
    public void add(Sc s);

    @Delete("delete from Sc where sid=#{sid} and cid=#{cid}")
    public void del(Long sid,Integer cid);

    @Update("update Sc " +
            "Set  sid = #{sid},cid=#{cid},pts=#{pts}" +
            "where sid=#{sid} and cid=#{cid}")
    public void edit(Sc e);
}

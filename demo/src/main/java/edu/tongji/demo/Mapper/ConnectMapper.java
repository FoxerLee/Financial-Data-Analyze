package edu.tongji.demo.Mapper;

import edu.tongji.demo.Model.Connect;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.ArrayList;

@Mapper
public interface ConnectMapper {
    @Select("select code, name from connect where code = \'${code}\'")
    ArrayList<Connect> getDataByCode(@Param("code") String code);

    @Select("select * from connect where name = \'${name}\'")
    ArrayList<Connect> getDataByName(@Param("name") String name);
}
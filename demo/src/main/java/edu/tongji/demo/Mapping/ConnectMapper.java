package edu.tongji.demo.Mapping;

import edu.tongji.demo.Model.Connect;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.ArrayList;

@Mapper
public interface ConnectMapper {
//    int deleteByPrimaryKey(String code);
//
//    int insert(Connect record);
//
//    int insertSelective(Connect record);
//
//    Connect selectByPrimaryKey(String code);
//
//    int updateByPrimaryKeySelective(Connect record);
//
//    int updateByPrimaryKey(Connect record);
    @Select("select * from connect where code = ${code}")
    ArrayList<Connect> getData(@Param("code") String code);
}
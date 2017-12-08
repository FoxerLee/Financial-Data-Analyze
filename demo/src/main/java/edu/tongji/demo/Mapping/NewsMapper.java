package edu.tongji.demo.Mapping;

import edu.tongji.demo.Model.News;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.ArrayList;

@Mapper
public interface NewsMapper {
//    int deleteByPrimaryKey(Integer id);
//
//    int insert(News record);
//
//    int insertSelective(News record);
//
//    News selectByPrimaryKey(Integer id);
//
//    int updateByPrimaryKeySelective(News record);
//
//    int updateByPrimaryKey(News record);
    @Select("select * from news where ${code} = code")
    ArrayList<News> getNews(@Param(value = "code") String code);
}
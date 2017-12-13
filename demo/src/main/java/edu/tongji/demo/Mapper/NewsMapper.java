package edu.tongji.demo.Mapper;

import edu.tongji.demo.Model.News;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.ArrayList;

@Mapper
public interface NewsMapper {
    @Select("select * from news where ${code} = code")
    ArrayList<News> getNews(@Param(value = "code") String code);
}
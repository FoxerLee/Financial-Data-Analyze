package edu.tongji.demo.DAO;

import edu.tongji.demo.Model.News;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.ArrayList;

@Mapper
public interface NewsMapper {
    @Select("select * from news where ${code} = code")
    ArrayList<News> getNews(@Param(value = "code") String code);

    @Select("select code, name, url, click from news where \'${code}\' = code limit 1, 6" )
    ArrayList<News> getEveryNews(@Param(value = "code")String code);
}
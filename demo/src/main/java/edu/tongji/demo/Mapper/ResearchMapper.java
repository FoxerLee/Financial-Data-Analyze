package edu.tongji.demo.Mapper;

import edu.tongji.demo.Model.Research;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.ArrayList;

@Mapper
public interface ResearchMapper {

    @Select("select code, title, url, date from research where code = \'${code}\'")
    public ArrayList<Research> getBriefResearchData(@Param(value = "code")String code);
}

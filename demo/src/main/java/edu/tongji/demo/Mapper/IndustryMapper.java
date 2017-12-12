package edu.tongji.demo.Mapper;

import edu.tongji.demo.Models.Industry;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.ArrayList;

@Mapper
public interface IndustryMapper {
    @Select("select * from industry order by turnover_p")
    ArrayList<Industry> getAllIndustryInfor();
}
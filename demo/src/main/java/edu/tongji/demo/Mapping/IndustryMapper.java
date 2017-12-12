package edu.tongji.demo.Mapping;

import edu.tongji.demo.Model.Industry;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.ArrayList;
import java.util.Objects;

@Mapper
public interface IndustryMapper {
//    int deleteByPrimaryKey(Integer id);
//
//    int insert(Industry record);
//
//    int insertSelective(Industry record);
//
//    Industry selectByPrimaryKey(Integer id);
//
//    int updateByPrimaryKeySelective(Industry record);
//
//    int updateByPrimaryKey(Industry record);

    @Select("select * from industry order by turnover_p")
    ArrayList<Industry> getAllIndustryInfor();
}
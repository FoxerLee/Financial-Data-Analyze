package edu.tongji.demo.Mapper;

import edu.tongji.demo.Model.DataDays;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.ArrayList;

@Mapper
public interface DataDaysMapper {

    @Select("select p_change from data_days where code = \'${code}\'"  )
    DataDays getPChangeByCode(@Param(value = "code")String code);
}
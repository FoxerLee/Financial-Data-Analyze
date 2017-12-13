package edu.tongji.demo.Mapper;

import edu.tongji.demo.Model.DataDays;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.ArrayList;

@Mapper
public interface DataDaysMapper {

    @Select("select code, p_change from data_days where code = \'${code}\'"  )
    ArrayList<DataDays> getPChangeByCode(@Param(value = "code")String code);
}
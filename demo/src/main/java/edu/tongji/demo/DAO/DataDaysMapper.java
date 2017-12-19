package edu.tongji.demo.DAO;

import edu.tongji.demo.Model.DataDays;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface DataDaysMapper {

    @Select("select p_change from data_days where code = ${code}"  )
    DataDays getPChangeByCode(@Param(value = "code")String code);
}
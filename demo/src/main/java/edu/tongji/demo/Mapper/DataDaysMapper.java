package edu.tongji.demo.Mapper;

import edu.tongji.demo.Models.BriefDataDays;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.ArrayList;

@Mapper
public interface DataDaysMapper {

    @Select("select data_days.code, data_days.trading_day, data_days.volume_value, connect.name, connect.c_name" +
            " from data_days left join connect using (code) where connect.c_name = \'${name}\n\' or connect.c_name = \'${name}\'"  )
    ArrayList<BriefDataDays> getStocksByIndustry(@Param(value = "name")String name);
}
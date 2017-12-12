package edu.tongji.demo.Mapper;

import edu.tongji.demo.Model.DataWeeks;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.ArrayList;

@Mapper
public interface DataWeeksMapper {

    @Select("select data_weeks.code, data_weeks.trading_day, data_weeks.open_value, data_weeks.close_value, data_weeks.high_value," +
            " data_weeks.low_value, data_weeks.volume_value, connect.name, connect.c_name" +
            " from data_weeks left join connect using (code) where connect.c_name = \'${name}\n\' or connect.c_name = \'${name}\'"  )
    ArrayList<DataWeeks> getStocksByIndustry(@Param(value = "name")String name);


}
package edu.tongji.demo.DAO;

import edu.tongji.demo.Model.WarehouseData;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.ArrayList;

@Mapper
public interface WarehouseDataWeeksMapper {

    @Select("select * from warehouse_data_weeks where code = \'${code}\' order by trading_day ")
    ArrayList<WarehouseData> getWareHouseData(@Param(value = "code")String code);
}

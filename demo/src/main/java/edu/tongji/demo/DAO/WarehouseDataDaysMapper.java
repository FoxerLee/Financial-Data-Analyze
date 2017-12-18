package edu.tongji.demo.DAO;

import edu.tongji.demo.Model.WarehouseDataDays;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.ArrayList;

@Mapper
public interface WarehouseDataDaysMapper {

    @Select("select * from warehouse_data_days where code = \'${code}\' order by trading_day ")
    public ArrayList<WarehouseDataDays> getWareHouseData(@Param(value = "code")String code);
}

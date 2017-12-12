package edu.tongji.demo.Mapper;

import edu.tongji.demo.Model.WarehouseDataRealTime;

public interface WarehouseDataRealTimeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(WarehouseDataRealTime record);

    int insertSelective(WarehouseDataRealTime record);

    WarehouseDataRealTime selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(WarehouseDataRealTime record);

    int updateByPrimaryKey(WarehouseDataRealTime record);
}
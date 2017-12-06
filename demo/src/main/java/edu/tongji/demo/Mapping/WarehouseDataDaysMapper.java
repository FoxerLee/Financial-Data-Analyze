package edu.tongji.demo.Mapping;

import edu.tongji.demo.Model.WarehouseDataDays;

public interface WarehouseDataDaysMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(WarehouseDataDays record);

    int insertSelective(WarehouseDataDays record);

    WarehouseDataDays selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(WarehouseDataDays record);

    int updateByPrimaryKey(WarehouseDataDays record);
}
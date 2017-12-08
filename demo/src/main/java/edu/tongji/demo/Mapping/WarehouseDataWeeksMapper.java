package edu.tongji.demo.Mapping;

import edu.tongji.demo.Model.WarehouseDataWeeks;

public interface WarehouseDataWeeksMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(WarehouseDataWeeks record);

    int insertSelective(WarehouseDataWeeks record);

    WarehouseDataWeeks selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(WarehouseDataWeeks record);

    int updateByPrimaryKey(WarehouseDataWeeks record);
}
package edu.tongji.demo.Mapping;

import edu.tongji.demo.Model.WarehouseDataMonhs;

public interface WarehouseDataMonhsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(WarehouseDataMonhs record);

    int insertSelective(WarehouseDataMonhs record);

    WarehouseDataMonhs selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(WarehouseDataMonhs record);

    int updateByPrimaryKey(WarehouseDataMonhs record);
}
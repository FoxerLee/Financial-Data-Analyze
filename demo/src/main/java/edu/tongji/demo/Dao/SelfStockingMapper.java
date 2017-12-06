package edu.tongji.demo.Dao;

import edu.tongji.demo.Model.SelfStockingKey;

public interface SelfStockingMapper {
    int deleteByPrimaryKey(SelfStockingKey key);

    int insert(SelfStockingKey record);

    int insertSelective(SelfStockingKey record);
}
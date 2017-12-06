package edu.tongji.demo.Dao;

import edu.tongji.demo.Model.GrowthData;

public interface GrowthDataMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(GrowthData record);

    int insertSelective(GrowthData record);

    GrowthData selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(GrowthData record);

    int updateByPrimaryKey(GrowthData record);
}
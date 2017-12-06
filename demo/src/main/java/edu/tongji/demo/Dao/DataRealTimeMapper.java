package edu.tongji.demo.Dao;

import edu.tongji.demo.Model.DataRealTime;

public interface DataRealTimeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(DataRealTime record);

    int insertSelective(DataRealTime record);

    DataRealTime selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DataRealTime record);

    int updateByPrimaryKey(DataRealTime record);
}
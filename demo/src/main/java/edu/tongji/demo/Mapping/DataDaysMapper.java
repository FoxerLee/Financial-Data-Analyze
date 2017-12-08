package edu.tongji.demo.Mapping;

import edu.tongji.demo.Model.DataDays;

public interface DataDaysMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(DataDays record);

    int insertSelective(DataDays record);

    DataDays selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DataDays record);

    int updateByPrimaryKey(DataDays record);
}
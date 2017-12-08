package edu.tongji.demo.Mapping;

import edu.tongji.demo.Model.DataWeeks;

public interface DataWeeksMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(DataWeeks record);

    int insertSelective(DataWeeks record);

    DataWeeks selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DataWeeks record);

    int updateByPrimaryKey(DataWeeks record);
}
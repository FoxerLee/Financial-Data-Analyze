package edu.tongji.demo.Mapping;

import edu.tongji.demo.Model.DataMonths;

public interface DataMonthsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(DataMonths record);

    int insertSelective(DataMonths record);

    DataMonths selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DataMonths record);

    int updateByPrimaryKey(DataMonths record);
}
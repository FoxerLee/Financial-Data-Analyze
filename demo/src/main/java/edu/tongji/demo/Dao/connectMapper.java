package edu.tongji.demo.Dao;

import edu.tongji.demo.Model.connect;

public interface connectMapper {
    int deleteByPrimaryKey(String code);

    int insert(connect record);

    int insertSelective(connect record);

    connect selectByPrimaryKey(String code);

    int updateByPrimaryKeySelective(connect record);

    int updateByPrimaryKey(connect record);
}
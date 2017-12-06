package edu.tongji.demo.Dao;

import edu.tongji.demo.Model.Connect;

public interface ConnectMapper {
    int deleteByPrimaryKey(String code);

    int insert(Connect record);

    int insertSelective(Connect record);

    Connect selectByPrimaryKey(String code);

    int updateByPrimaryKeySelective(Connect record);

    int updateByPrimaryKey(Connect record);
}
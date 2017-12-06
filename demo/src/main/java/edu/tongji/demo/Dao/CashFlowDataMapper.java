package edu.tongji.demo.Dao;

import edu.tongji.demo.Model.CashFlowData;

public interface CashFlowDataMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CashFlowData record);

    int insertSelective(CashFlowData record);

    CashFlowData selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CashFlowData record);

    int updateByPrimaryKey(CashFlowData record);
}
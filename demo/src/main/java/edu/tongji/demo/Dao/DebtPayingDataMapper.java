package edu.tongji.demo.Dao;

import edu.tongji.demo.Model.DebtPayingData;

public interface DebtPayingDataMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(DebtPayingData record);

    int insertSelective(DebtPayingData record);

    DebtPayingData selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DebtPayingData record);

    int updateByPrimaryKey(DebtPayingData record);
}
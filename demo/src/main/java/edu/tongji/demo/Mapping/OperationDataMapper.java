package edu.tongji.demo.Mapping;

import edu.tongji.demo.Model.OperationData;

public interface OperationDataMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(OperationData record);

    int insertSelective(OperationData record);

    OperationData selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(OperationData record);

    int updateByPrimaryKey(OperationData record);
}
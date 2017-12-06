package edu.tongji.demo.Dao;

import edu.tongji.demo.Model.CompanyInfo;
import edu.tongji.demo.Model.CompanyInfoWithBLOBs;

public interface CompanyInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CompanyInfoWithBLOBs record);

    int insertSelective(CompanyInfoWithBLOBs record);

    CompanyInfoWithBLOBs selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CompanyInfoWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(CompanyInfoWithBLOBs record);

    int updateByPrimaryKey(CompanyInfo record);
}
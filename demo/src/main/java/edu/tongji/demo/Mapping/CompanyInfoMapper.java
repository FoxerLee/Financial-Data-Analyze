package edu.tongji.demo.Mapping;

import edu.tongji.demo.Model.CompanyInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.ArrayList;

@Mapper
public interface CompanyInfoMapper {
//    int deleteByPrimaryKey(Integer id);
//
//    int insert(CompanyInfoWithBLOBs record);
//
//    int insertSelective(CompanyInfoWithBLOBs record);
//
//    CompanyInfoWithBLOBs selectByPrimaryKey(Integer id);
//
//    int updateByPrimaryKeySelective(CompanyInfoWithBLOBs record);
//
//    int updateByPrimaryKeyWithBLOBs(CompanyInfoWithBLOBs record);
//
//    int updateByPrimaryKey(CompanyInfo record);

    @Select("select * from company_info where code = ${code}")
    ArrayList<CompanyInfo> getData(@Param(value = "code") String code);
}
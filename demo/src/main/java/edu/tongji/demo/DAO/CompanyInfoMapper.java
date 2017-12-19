package edu.tongji.demo.DAO;

import edu.tongji.demo.Model.CompanyInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.ArrayList;

@Mapper
public interface CompanyInfoMapper {
    @Select("select * from company_info where code = ${code}")
    ArrayList<CompanyInfo> getData(@Param(value = "code") String code);
}
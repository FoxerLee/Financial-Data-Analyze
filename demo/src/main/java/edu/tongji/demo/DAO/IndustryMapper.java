package edu.tongji.demo.DAO;

import edu.tongji.demo.Model.Industry;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.ArrayList;

@Mapper
public interface IndustryMapper {
    @Select("select * from industry order by turnover_p")
    ArrayList<Industry> getAllIndustryInfor();

    @Select("select code, name from connect where c_name = \'${c_name}\n\' or c_name = \'${c_name}\'")
    public ArrayList<Industry> getConnectByCName(@Param(value = "c_name")String c_name);
}
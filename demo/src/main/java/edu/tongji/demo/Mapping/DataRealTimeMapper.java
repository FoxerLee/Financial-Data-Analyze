package edu.tongji.demo.Mapping;

import edu.tongji.demo.Model.DataRealTime;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface DataRealTimeMapper {
    @Select("select * from data_real_time where code=${code}")
    DataRealTime GetDataByCode();
}
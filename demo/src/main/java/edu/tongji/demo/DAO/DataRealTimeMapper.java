package edu.tongji.demo.DAO;

import edu.tongji.demo.Model.DataRealTime;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface DataRealTimeMapper {
    @Select("select * from data_real_time where code=${code}")
    DataRealTime GetDataByCode();

    @Select("select * from data_real_time where code = \'${code}\' and trading_day = (" +
            "select max(trading_day) from data_real_time where code = \'${code}\')")
    public DataRealTime getPresentData(@Param(value = "code") String code);
}
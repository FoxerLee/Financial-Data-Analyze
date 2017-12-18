package edu.tongji.demo.DAO;

import edu.tongji.demo.Model.SelfStocking;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.ArrayList;

@Mapper
public interface SelfStockingMapper {

    @Select("select code from self_stocking where user_id = ${id}")
    ArrayList<SelfStocking> getStockByID(@Param(value = "id")Integer id);
}

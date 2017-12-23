package edu.tongji.demo.DAO;

import edu.tongji.demo.Model.SelfStocking;
import org.apache.ibatis.annotations.*;

import java.util.ArrayList;

@Mapper
public interface SelfStockingMapper {

    @Select("select code from self_stocking where user_id = ${id}")
    ArrayList<SelfStocking> getStockByID(@Param(value = "id")Integer id);

    @Insert("insert into self_stocking(user_id, code) values(${id}, \'${code}\')")
    void addStockCode(@Param("id")Integer id, @Param("code")String code);

    @Delete("delete from self_stocking where user_id = ${id} and code = \'${code}\'")
    void deleteStockCode(@Param("id")Integer id, @Param("code")String code);
}

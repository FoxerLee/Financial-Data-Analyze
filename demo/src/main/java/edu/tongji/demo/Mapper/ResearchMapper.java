package edu.tongji.demo.Mapper;

import edu.tongji.demo.Model.Research;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.ArrayList;

@Mapper
public interface ResearchMapper {

    @Select("select code, title, url, date from research where code = \'${code}\' limit 1, 6")
    public ArrayList<Research> getBriefResearchData(@Param(value = "code")String code);

    @Select()

    @Select("select * from self_stocking join research join user_info" +
            "where research.code = self_stocking.code and user_info.user_id = self_stocking.user_id" +
            "and user_info.name = \'${name}\'")
    ArrayList<Research> getPersonalStock(@Param("name")String name);
}

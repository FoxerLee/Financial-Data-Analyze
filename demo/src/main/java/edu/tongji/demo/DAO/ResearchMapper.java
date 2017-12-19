package edu.tongji.demo.DAO;

import edu.tongji.demo.Model.Research;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.ArrayList;

@Mapper
public interface ResearchMapper {

    @Select("select code, title, url, date from research where code = \'${code}\' limit 1, 6")
    public ArrayList<Research> getBriefResearchData(@Param(value = "code")String code);

    @Select("select research.* from self_stocking join research where research.code = self_stocking.code and ${id} = self_stocking.user_id")
    ArrayList<Research> getPersonalStock(@Param("id")Integer id);
}

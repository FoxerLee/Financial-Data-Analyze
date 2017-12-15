package edu.tongji.demo.Mapper;

import edu.tongji.demo.Model.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserInfoMapper {

    @Select("select name, password from user_info where name = \"${name}\" and password = \"${password}\"")
    UserInfo Vefify(@Param(value = "name") String name, @Param(value = "password") String password);
}
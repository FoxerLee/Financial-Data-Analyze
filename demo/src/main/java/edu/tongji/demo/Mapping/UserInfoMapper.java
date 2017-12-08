package edu.tongji.demo.Mapping;

import edu.tongji.demo.Model.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserInfoMapper {
//    int deleteByPrimaryKey(Integer userId);
//
//    int insert(UserInfo record);
//
//    int insertSelective(UserInfo record);
//
//    UserInfo selectByPrimaryKey(Integer userId);
//
//    int updateByPrimaryKeySelective(UserInfo record);
//
//    int updateByPrimaryKey(UserInfo record);

    @Select("select name, password from user_info where name = \"${name}\" and password = \"${password}\"")
    UserInfo Vefify(@Param(value = "name") String name, @Param(value = "password") String password);
}
package edu.tongji.demo.DAO;

import edu.tongji.demo.Model.UserInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserInfoMapper {

    @Select("select name, password from user_info where name = \"${name}\" and password = \"${password}\"")
    UserInfo Vefify(@Param(value = "name") String name, @Param(value = "password") String password);

    @Select("select count(*) from user_info where name=\'${name}\'")
    Integer Check(@Param(value = "name")String name);

    @Insert("insert into user_info(name, password, email, nickname) values(\'${name}\', \'${password}\', \'${email}\', \'${nickname}\')")
    void AddUser( @Param(value = "name")String name, @Param(value = "password")String password,
                 @Param(value = "email")String email, @Param(value = "nickname")String nickname);

    @Select("select user_id from user_info where name = \'${name}\'")
    Integer getID(@Param(value = "name")String name);

    @Select("select * from user_info where name = \'${name}\'")
    UserInfo getInformationByName(@Param("name") String name);
}
package edu.tongji.demo.Mapper;

import edu.tongji.demo.Model.ProfileData;

public interface ProfileDataMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ProfileData record);

    int insertSelective(ProfileData record);

    ProfileData selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ProfileData record);

    int updateByPrimaryKey(ProfileData record);
}
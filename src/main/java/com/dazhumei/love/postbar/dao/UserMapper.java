package com.dazhumei.love.postbar.dao;

import org.apache.ibatis.annotations.Mapper;

import com.dazhumei.love.postbar.entity.User;
@Mapper
public interface UserMapper {
    int deleteByPrimaryKey(String id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}
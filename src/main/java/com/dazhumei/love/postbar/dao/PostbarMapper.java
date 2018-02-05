package com.dazhumei.love.postbar.dao;

import com.dazhumei.love.postbar.entity.Postbar;

public interface PostbarMapper {
    int deleteByPrimaryKey(String id);

    int insert(Postbar record);

    int insertSelective(Postbar record);

    Postbar selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Postbar record);

    int updateByPrimaryKey(Postbar record);
}
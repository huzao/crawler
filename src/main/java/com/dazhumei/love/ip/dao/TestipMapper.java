package com.dazhumei.love.ip.dao;

import org.apache.ibatis.annotations.Mapper;

import com.dazhumei.love.ip.entity.Testip;
@Mapper
public interface TestipMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Testip record);

    /**
     * 添加
     * @param testip
     * @return
     */
    public int addTestip(Testip testip);

    Testip selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Testip record);

    int updateByPrimaryKey(Testip record);
}
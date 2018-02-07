package com.dazhumei.love.postbar.dao;

import org.apache.ibatis.annotations.Mapper;

import com.dazhumei.love.postbar.entity.User;
@Mapper
public interface UserMapper {
    int deleteByPrimaryKey(String id);

    int insert(User record);

    /**
     * 添加作者
     * @param record
     * @return
     */
    public int insertUser(User user);

    /**
     * 查询作者通过作者名字
     * @param id
     * @return
     */
    public User selectUserByUname(String uname);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}
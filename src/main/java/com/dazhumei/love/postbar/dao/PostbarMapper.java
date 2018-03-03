package com.dazhumei.love.postbar.dao;

import org.apache.ibatis.annotations.Mapper;

import com.dazhumei.love.postbar.entity.Postbar;

@Mapper
public interface PostbarMapper {

	int deleteByPrimaryKey(String id);

	int insert(Postbar record);

	/**
	 * 添加贴吧
	 * 
	 * @param postbar
	 * @return
	 */
	int insertPostBar(Postbar postbar);

	Postbar selectByPrimaryKey(String id);

	int updateByPrimaryKeySelective(Postbar record);

	int updatePostbar(Postbar postbar);
}
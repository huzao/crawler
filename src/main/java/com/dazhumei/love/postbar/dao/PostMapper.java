package com.dazhumei.love.postbar.dao;

import org.apache.ibatis.annotations.Mapper;

import com.dazhumei.love.postbar.entity.Post;

@Mapper
public interface PostMapper {
	
	/**
	 * 添加帖子
	 * @param post
	 * @return
	 */
	public int insertPost(Post post);
	
}
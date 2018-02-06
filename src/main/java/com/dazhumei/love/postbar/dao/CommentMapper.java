package com.dazhumei.love.postbar.dao;

import org.apache.ibatis.annotations.Mapper;

import com.dazhumei.love.postbar.entity.Comment;
@Mapper
public interface CommentMapper {

	/**
	 * 添加评论
	 * @param comment
	 * @return
	 */
    public int insertComment(Comment comment);

}
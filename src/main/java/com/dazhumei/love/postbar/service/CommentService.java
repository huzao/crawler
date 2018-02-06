package com.dazhumei.love.postbar.service;

import com.dazhumei.love.postbar.entity.Comment;

public interface CommentService {
	
	/**
	 * 添加评论
	 * @param comment
	 * @return
	 */
    public int insertComment(Comment comment);

}

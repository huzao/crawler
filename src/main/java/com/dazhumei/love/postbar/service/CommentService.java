package com.dazhumei.love.postbar.service;

import java.util.List;

import com.dazhumei.love.postbar.entity.Comment;
import com.dazhumei.love.postbar.entity.Post;

public interface CommentService {
	
	/**
	 * 添加评论
	 * @param comment
	 * @return
	 */
    public int insertComment(Comment comment);
    
    /**
     * 删除对应帖子的评论
     * @param postid
     */
    public int deleteCommentByPostid(String postid);
    
    /**
     * 批量删除对应帖子的评论
     * @param postid
     */
    public int deleteCommentsByPostid(List<Post> list);
    
    /**
     * 批量添加评论
     * @param postid
     */
    public int insertCommentList(List<Comment> list);

}

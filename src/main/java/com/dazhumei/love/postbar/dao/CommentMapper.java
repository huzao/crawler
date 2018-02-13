package com.dazhumei.love.postbar.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.dazhumei.love.postbar.entity.Comment;
import com.dazhumei.love.postbar.entity.Post;
@Mapper
public interface CommentMapper {

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
      * 批量添加对应帖子的评论
      * @param postid
      */
     public int insertCommentList(List<Comment> list);

}
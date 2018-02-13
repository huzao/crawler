package com.dazhumei.love.postbar.dao;

import java.util.List;

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
	
	/**
	 * 查处某个贴吧的所以帖子
	 * @param postbarid
	 * @return
	 */
	public List<Post> selectPostByPostbarid(String postbarid);
	
	/**
	 * 删除某个贴吧的所以帖子
	 * @param postbarid
	 * @return
	 */
	public int deletePostByPostbarid(String postbarid);
	 
	 /**
	 * 批量添加
	 * @param postbarid
	 * @return
	 */
	public int insertPostList(List<Post> list);
	
	
	
}
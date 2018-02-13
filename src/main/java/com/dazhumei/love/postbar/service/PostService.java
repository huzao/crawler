package com.dazhumei.love.postbar.service;

import java.util.List;

import com.dazhumei.love.postbar.entity.Post;

public interface PostService {
	
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

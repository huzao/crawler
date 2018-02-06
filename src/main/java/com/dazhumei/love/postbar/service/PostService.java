package com.dazhumei.love.postbar.service;

import com.dazhumei.love.postbar.entity.Post;

public interface PostService {
	
	/**
	 * 添加帖子
	 * @param post
	 * @return
	 */
	public int insertPost(Post post);

}

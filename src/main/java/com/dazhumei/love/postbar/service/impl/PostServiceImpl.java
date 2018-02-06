package com.dazhumei.love.postbar.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dazhumei.love.postbar.dao.PostMapper;
import com.dazhumei.love.postbar.entity.Post;
import com.dazhumei.love.postbar.service.PostService;

@Service
@Transactional
public class PostServiceImpl implements PostService{
	
	@Autowired
	private PostMapper postDao;

	@Override
	public int insertPost(Post post) {
		return postDao.insertPost(post);
	}

}

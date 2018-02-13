package com.dazhumei.love.postbar.service.impl;

import java.util.List;

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

	@Override
	public List<Post> selectPostByPostbarid(String postbarid) {
		return postDao.selectPostByPostbarid(postbarid);
	}

	@Override
	public int deletePostByPostbarid(String postbarid) {
		return postDao.deletePostByPostbarid(postbarid);
	}

	@Override
	public int insertPostList(List<Post> list) {
		return postDao.insertPostList(list);
	}

}

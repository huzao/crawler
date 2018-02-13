package com.dazhumei.love.postbar.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dazhumei.love.postbar.dao.CommentMapper;
import com.dazhumei.love.postbar.entity.Comment;
import com.dazhumei.love.postbar.entity.Post;
import com.dazhumei.love.postbar.service.CommentService;
@Service
@Transactional
public class CommentServiceImpl implements CommentService{
	
	@Autowired
	private CommentMapper commentDao;

	@Override
	public int insertComment(Comment comment) {
		return commentDao.insertComment(comment);
	}

	@Override
	public int deleteCommentByPostid(String postid) {
		return commentDao.deleteCommentByPostid(postid);
	}

	@Override
	public int deleteCommentsByPostid(List<Post> list) {
		return commentDao.deleteCommentsByPostid(list);
	}

	@Override
	public int insertCommentList(List<Comment> list) {
		return commentDao.insertCommentList(list);
	}

}

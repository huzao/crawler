package com.dazhumei.love.postbar.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dazhumei.love.postbar.dao.PostbarMapper;
import com.dazhumei.love.postbar.entity.Postbar;
import com.dazhumei.love.postbar.service.PostBarService;
@Service
@Transactional
public class PostBarServiceImpl implements PostBarService{
	
	@Autowired
	private PostbarMapper postbarDao;

	@Override
	public int insertPostBar(Postbar postbar) {
		return postbarDao.insertPostBar(postbar);
	}

	@Override
	public int updatePostbar(Postbar postbar) {
		return postbarDao.updatePostbar(postbar);
	}

}

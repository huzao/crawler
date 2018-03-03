package com.dazhumei.love.postbar.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dazhumei.love.postbar.dao.UserMapper;
import com.dazhumei.love.postbar.entity.User;
import com.dazhumei.love.postbar.service.UserService;
@Service
@Transactional
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserMapper userDao;

	@Override
	public int insertUser(User user) {
		return userDao.insertUser(user);
	}

	@Override
	public User selectUserByUname(String uname) {
		return userDao.selectUserByUname(uname);
	}

	@Override
	public int insertUserList(List<User> list) {
		return userDao.insertUserList(list);
	}

}

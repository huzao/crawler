package com.dazhumei.love.ip.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dazhumei.love.ip.dao.TestipMapper;
import com.dazhumei.love.ip.entity.Testip;
import com.dazhumei.love.ip.service.TestipService;

@Service
@Transactional
public class TestipServiceImpl implements TestipService {
	
	@Autowired
	private TestipMapper testipdao;

	@Override
	public int addTestip(Testip testip) {
		return testipdao.addTestip(testip);
	}

}

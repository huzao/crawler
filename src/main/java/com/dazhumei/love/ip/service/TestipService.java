package com.dazhumei.love.ip.service;

import java.util.List;

import com.dazhumei.love.ip.entity.Testip;

public interface TestipService {
	
	/**
     * 添加
     * @param testip
     * @return
     */
    public int addTestip(Testip testip);
    
    /**
     * 批量添加
     * @param list
     * @return
     */
    public int addTestipList(List<Testip> list);

}

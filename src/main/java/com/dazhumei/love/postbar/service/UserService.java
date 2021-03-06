package com.dazhumei.love.postbar.service;

import java.util.List;

import com.dazhumei.love.postbar.entity.User;

public interface UserService {
	
	/**
     * 添加作者
     * @param record
     * @return
     */
    public int insertUser(User user);
    
    /**
     * 查询作者通过作者名字
     * @param id
     * @return
     */
    public User selectUserByUname(String uname);
    
    /**
   	 * 批量添加
   	 * @param list
   	 * @return
   	 */
   	public int insertUserList(List<User> list);

}

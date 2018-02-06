package com.dazhumei.love.postbar.entity;

import java.util.Date;

public class User {
	private String id;
	//用户名
	private String uname;
	//等级
	private String urank;
	//创建时间
	private Date creatTime;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id == null ? null : id.trim();
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname == null ? null : uname.trim();
	}

	public String getUrank() {
		return urank;
	}

	public void setUrank(String urank) {
		this.urank = urank == null ? null : urank.trim();
	}

	public Date getCreatTime() {
		return creatTime;
	}

	public void setCreatTime(Date creatTime) {
		this.creatTime = creatTime;
	}
}
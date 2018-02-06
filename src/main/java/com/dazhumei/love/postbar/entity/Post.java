package com.dazhumei.love.postbar.entity;

public class Post {
	private String id;
	//贴吧id
	private String postbarid;
	//回复数
	private String repnum;
	//帖子作者
	private String pauthor;
	//创建时间
	private String creatTime;
	//最好评论人
	private String lastpeople;
	//最后评论时间
	private String lastTime;
	//帖子网址
	private String posturl;
	//帖子题目
	private String posttitle;
	//帖子内容（简介）
	private String content;

	public String getPosttitle() {
		return posttitle;
	}

	public void setPosttitle(String posttitle) {
		this.posttitle = posttitle;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id == null ? null : id.trim();
	}

	public String getPostbarid() {
		return postbarid;
	}

	public void setPostbarid(String postbarid) {
		this.postbarid = postbarid == null ? null : postbarid.trim();
	}

	public String getRepnum() {
		return repnum;
	}

	public void setRepnum(String repnum) {
		this.repnum = repnum == null ? null : repnum.trim();
	}

	public String getPauthor() {
		return pauthor;
	}

	public void setPauthor(String pauthor) {
		this.pauthor = pauthor == null ? null : pauthor.trim();
	}

	public String getCreatTime() {
		return creatTime;
	}

	public void setCreatTime(String creatTime) {
		this.creatTime = creatTime;
	}

	public String getLastpeople() {
		return lastpeople;
	}

	public void setLastpeople(String lastpeople) {
		this.lastpeople = lastpeople == null ? null : lastpeople.trim();
	}

	public String getLastTime() {
		return lastTime;
	}

	public void setLastTime(String lastTime) {
		this.lastTime = lastTime;
	}

	public String getPosturl() {
		return posturl;
	}

	public void setPosturl(String posturl) {
		this.posturl = posturl == null ? null : posturl.trim();
	}
}
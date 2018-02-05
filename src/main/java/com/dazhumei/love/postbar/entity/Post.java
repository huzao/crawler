package com.dazhumei.love.postbar.entity;

import java.util.Date;

public class Post {
    private String id;

    private String postbarid;

    private String repnum;

    private String pauthor;

    private Date creatTime;

    private String lastpeople;

    private Date lastTime;

    private String posturl;
    
    private String posttitle;

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

    public Date getCreatTime() {
        return creatTime;
    }

    public void setCreatTime(Date creatTime) {
        this.creatTime = creatTime;
    }

    public String getLastpeople() {
        return lastpeople;
    }

    public void setLastpeople(String lastpeople) {
        this.lastpeople = lastpeople == null ? null : lastpeople.trim();
    }

    public Date getLastTime() {
        return lastTime;
    }

    public void setLastTime(Date lastTime) {
        this.lastTime = lastTime;
    }

    public String getPosturl() {
        return posturl;
    }

    public void setPosturl(String posturl) {
        this.posturl = posturl == null ? null : posturl.trim();
    }
}
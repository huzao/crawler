package com.dazhumei.love.postbar.entity;

import java.util.Date;

public class Postbar {
    private String id;

    private String title;

    private String postbar;

    private String concernnum;

    private String postnum;

    private Date creatTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getPostbar() {
        return postbar;
    }

    public void setPostbar(String postbar) {
        this.postbar = postbar == null ? null : postbar.trim();
    }

    public String getConcernnum() {
        return concernnum;
    }

    public void setConcernnum(String concernnum) {
        this.concernnum = concernnum == null ? null : concernnum.trim();
    }

    public String getPostnum() {
        return postnum;
    }

    public void setPostnum(String postnum) {
        this.postnum = postnum == null ? null : postnum.trim();
    }

    public Date getCreatTime() {
        return creatTime;
    }

    public void setCreatTime(Date creatTime) {
        this.creatTime = creatTime;
    }
}
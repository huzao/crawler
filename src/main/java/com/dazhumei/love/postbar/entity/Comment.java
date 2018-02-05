package com.dazhumei.love.postbar.entity;

import java.util.Date;

public class Comment {
    private String id;

    private String postid;

    private String cauthor;

    private String carank;

    private Date creatTime;

    private String comment;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getPostid() {
        return postid;
    }

    public void setPostid(String postid) {
        this.postid = postid == null ? null : postid.trim();
    }

    public String getCauthor() {
        return cauthor;
    }

    public void setCauthor(String cauthor) {
        this.cauthor = cauthor == null ? null : cauthor.trim();
    }

    public String getCarank() {
        return carank;
    }

    public void setCarank(String carank) {
        this.carank = carank == null ? null : carank.trim();
    }

    public Date getCreatTime() {
        return creatTime;
    }

    public void setCreatTime(Date creatTime) {
        this.creatTime = creatTime;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment == null ? null : comment.trim();
    }
}
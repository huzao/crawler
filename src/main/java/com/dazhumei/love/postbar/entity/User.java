package com.dazhumei.love.postbar.entity;

import java.util.Date;

public class User {
    private String id;

    private String uname;

    private String urank;

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
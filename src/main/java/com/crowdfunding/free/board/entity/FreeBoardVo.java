package com.crowdfunding.free.board.entity;

import java.text.SimpleDateFormat;
import java.util.Date;

public class FreeBoardVo {
    private int num;
    private String title;
    private String content;
    private Date regdate;
    private int viewCnt;
    private String userId;

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getRegdate() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yy/MM/dd");
        return simpleDateFormat.format(this.regdate);
    }

    public void setRegdate(Date regdate) {
        this.regdate = regdate;
    }

    public int getViewCnt() {
        return viewCnt;
    }

    public void setViewCnt(int viewCnt) {
        this.viewCnt = viewCnt;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "FreeBoardVo{" +
                "bno=" + num +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", regdate=" + regdate +
                ", viewCnt=" + viewCnt +
                ", membershipTableUserId='" + userId + '\'' +
                '}';
    }
}

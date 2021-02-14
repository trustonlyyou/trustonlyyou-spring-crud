package com.crowdfunding.board.entity;

import java.text.SimpleDateFormat;
import java.util.Date;

public class FreeBoardVo {
    private Integer num;
    private String title;
    private String content;
    private Date regdate;
    private int viewCnt;
    private String membershipTableUserId;

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
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

    public String getMembershipTableUserId() {
        return membershipTableUserId;
    }

    public void setMembershipTableUserId(String membershipTableUserId) {
        this.membershipTableUserId = membershipTableUserId;
    }

    @Override
    public String toString() {
        return "FreeBoardVo{" +
                "bno=" + num +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", regdate=" + regdate +
                ", viewCnt=" + viewCnt +
                ", membershipTableUserId='" + membershipTableUserId + '\'' +
                '}';
    }
}

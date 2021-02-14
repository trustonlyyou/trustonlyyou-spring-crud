package com.crowdfunding.board.entity;

public class Standard {

    private int page;
    private int perPageNum;

    public Standard() {
        this.page = 1;
        this.perPageNum = 5;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        if (page <= 0) {
            this.page = 1;
            return;
        }
        this.page = page;
    }

    public int getPerPageNum() {
        return perPageNum;
    }

    public void setPerPageNum(int perPageNum) {
        if (perPageNum <= 0 || perPageNum > 100) {
            this.perPageNum = 5;
            return;
        }
        this.perPageNum = perPageNum;
    }

    public int getPageStart() {
        return (this.page - 1) * perPageNum;
    }

}

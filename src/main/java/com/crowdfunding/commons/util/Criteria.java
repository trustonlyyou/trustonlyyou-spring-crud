package com.crowdfunding.commons.util;

public class Criteria {

    private int page; // 현재 페이지 번호
    private int perPageNum; // 페이자 당 출력되는 게시글의 개수

    public Criteria() {
        this.page = 1;
        this.perPageNum = 10;
    }

    // validation check
    public void setPage(int page) {
        if (page <= 0) {
            this.page = 1;
            return;
        }
        this.page = page;
    }

    // validation check
    public void setPerPageNum(int perPageNum) {
        if (perPageNum <= 0 || perPageNum > 100) {
            this.perPageNum = 10;
            return;
        }
        this.perPageNum = perPageNum;
    }

    public int getPage() {
        return page;
    }

    /**
     * ※ page 는 몇번째 페이지 인지를 말한다. 첫  번째 페이지인지 두 번째 페이지 인지
     *
     * SQl Connection LIMIT
     *     ex LIMIT A , B
     *     page == 3 perPageNUm == 10 :: getPageStart() is return 20
     *
     * @return A
     */
    public int getPageStart() {
        return (this.page - 1) * perPageNum;
        // 시작 데이터 번호 = (페이지 번호 - 1) * 페이지당 보여주는 개수
    }

    public int getPerPageNum() {
        return perPageNum;
    }

    @Override
    public String toString() {
        return "Criteria{" +
                "page=" + page +
                ", perPageNum=" + perPageNum +
                '}';
    }
}

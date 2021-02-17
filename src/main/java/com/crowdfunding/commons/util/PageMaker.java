package com.crowdfunding.commons.util;

import com.crowdfunding.free.myboard.entity.MyBoardCriteria;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

public class PageMaker {

    private final int DISPLAY_PAGE_NUM = 10; // 하단에 보여지는 페이지 번호의 숫자

    private Criteria criteria;

    private int totalCount;
    private int startPage;
    private int endPage;
    private boolean prev;
    private boolean next;

    public void setCriteria(Criteria criteria) {
        this.criteria = criteria;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
        calcData();
    }

    private void calcData() {
        endPage = (int) (Math.ceil(criteria.getPage() / (double) DISPLAY_PAGE_NUM) * DISPLAY_PAGE_NUM);
        // 하단 페이지의 끝 번호 = (현재 페이지 / 하단에 보여지는 페이지 번호의 숫자) * 하단에 보여지는 페이지 번호의 숫자
        //  현재 페이지가 3 이라면 (3 / 10) * 10 = 10
        // 현재 페이지가 1 이라면 (20 / 10 ) * 10 = 10


        startPage = (endPage - DISPLAY_PAGE_NUM) + 1;
        // 하단 페이지의 시작 번호 = (끝 번호 - 하단에 보여지는 페이지 번호의 숫자) + 1
        // 끝번호가 10 이라면  (10 - 10) + 1 , startPage = 1
        // 끝번호가 20 이라면  (20 - 10) + 1 , startPage = 11

        // endPage 재계산
        int tempEndPage = (int) (Math.ceil(totalCount / (double) criteria.getPerPageNum()));

        if (endPage > tempEndPage) {
            endPage = tempEndPage;
        }

        prev = startPage == 1 ? false : true;
        // prev 계산, 단순이 startPage 가 1인지 아닌지만 판명 하면 된다.

        next = endPage * criteria.getPerPageNum() >= totalCount ? false : true;
        // 뒤에 남은 데이터가 있는지 없는지 확인 해야 하므로
        // 하단 페이지의 끝 번호 * 페이지당 보여줄 데이터의 개수 가 총 게시물 개수보다 커야한다.
    }

    public String makeQuery(int page) {
        UriComponents uriComponents =
                UriComponentsBuilder.newInstance()
                .queryParam("page", page)
                .queryParam("perPageNum", criteria.getPerPageNum())
                .build();
        return uriComponents.toString();
    }

    public Criteria getCriteria() {
        return criteria;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public int getStartPage() {
        return startPage;
    }

    public void setStartPage(int startPage) {
        this.startPage = startPage;
    }

    public int getEndPage() {
        return endPage;
    }

    public void setEndPage(int endPage) {
        this.endPage = endPage;
    }

    public boolean isPrev() {
        return prev;
    }

    public void setPrev(boolean prev) {
        this.prev = prev;
    }

    public boolean isNext() {
        return next;
    }

    public void setNext(boolean next) {
        this.next = next;
    }
}

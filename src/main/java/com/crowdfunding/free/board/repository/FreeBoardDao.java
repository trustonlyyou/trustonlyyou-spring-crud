package com.crowdfunding.free.board.repository;

import com.crowdfunding.commons.util.Criteria;
import com.crowdfunding.free.board.entity.FreeBoardVo;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class FreeBoardDao {

    @Autowired
    SqlSessionTemplate sessionTemplate;

    public List<FreeBoardVo> getFreeBoardList(Criteria criteria) throws Exception {
        try {
            return sessionTemplate.selectList("freeBoardList", criteria);
        } catch (Exception e) {
            throw e;
        }
    }

    public int getCountingData(Criteria criteria) throws Exception {
        try {
            return sessionTemplate.selectOne("countingData", criteria);
        } catch (Exception e) {
            throw e;
        }
    }

    public int getMaxNum() throws Exception {
        try {
            return sessionTemplate.selectOne("maxNum");
        } catch (Exception e) {
            throw e;
        }
    }

    public FreeBoardVo getDetailData(int numCalc) throws Exception {
        try {
            return sessionTemplate.selectOne("detailData", numCalc);
        } catch (Exception e) {
            throw e;
        }
    }

    public void setWrite(FreeBoardVo freeBoardVo) throws Exception {
        try {
            sessionTemplate.insert("write", freeBoardVo);
        } catch (Exception e) {
            throw e;
        }
    }

    public void updateViewCnt(int index) throws Exception {
        try {
            sessionTemplate.update("upViewCnt", index);
        } catch (Exception e) {
            throw e;
        }
    }
}

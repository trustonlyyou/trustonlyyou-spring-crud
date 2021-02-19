package com.crowdfunding.free.myboard.repository;

import com.crowdfunding.commons.util.PageMaker;
import com.crowdfunding.free.board.entity.FreeBoardVo;
import com.crowdfunding.free.myboard.entity.MyBoardCriteria;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class MyBoardDao {

    @Autowired
    private SqlSessionTemplate sessionTemplate;

    public List<FreeBoardVo> getMyBoardList(Map<String, Object> map) throws Exception {
        try {
            return sessionTemplate.selectList("myBoardList", map);
        } catch (Exception e) {
            throw e;
        }
    }

    public int getMyBoardCountingData(String userId) throws Exception {
        try {
            return sessionTemplate.selectOne("myBoardCountingData", userId);
        } catch (Exception e) {
            throw e;
        }
    }

    public FreeBoardVo getMyBoardDetailData(Map<String, Object> map) throws Exception {
        try {
            return sessionTemplate.selectOne("myBoardDetailData", map);
        } catch (Exception e) {
            throw e;
        }
    }

    public void myBoardDataModify(Map<String, Object> map) throws Exception {
        try {
            sessionTemplate.update("myBoardDataModify", map);
        } catch (Exception e) {
            throw e;
        }
    }

    public void myBoardDataDelete(int numId) throws Exception {
        try {
            sessionTemplate.delete("myBoardDataDelete", numId);
        } catch (Exception e) {
            throw e;
        }
    }

}

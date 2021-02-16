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
}

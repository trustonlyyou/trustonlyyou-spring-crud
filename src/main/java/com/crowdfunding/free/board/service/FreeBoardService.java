package com.crowdfunding.free.board.service;

import com.crowdfunding.commons.util.Criteria;
import com.crowdfunding.free.board.entity.FreeBoardVo;
import com.crowdfunding.free.board.repository.FreeBoardDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FreeBoardService {

    @Autowired
    FreeBoardDao boardDao;

    public List<FreeBoardVo> getBoardList(Criteria criteria) throws Exception {
        try {
            return boardDao.getFreeBoardList(criteria);
        } catch (Exception e) {
            throw e;
        }
    }

    public int getCountingData(Criteria criteria) throws Exception {
        try {
            return boardDao.getCountingData(criteria);
        } catch (Exception e) {
            throw e;
        }
    }

    public FreeBoardVo getDetailData(int numCalc) throws Exception {
        try {
            return boardDao.getDetailData(numCalc);
        } catch (Exception e) {
            throw e;
        }
    }
}

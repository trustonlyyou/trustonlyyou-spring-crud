package com.crowdfunding.free.myboard.service;

import com.crowdfunding.free.board.entity.FreeBoardVo;
import com.crowdfunding.free.myboard.entity.MyBoardCriteria;
import com.crowdfunding.free.myboard.repository.MyBoardDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class MyBoardService {

    @Autowired
    private MyBoardDao boardDao;

    public List<FreeBoardVo> getMyBoardList(Map<String, Object> map) throws Exception {
        try {
            return boardDao.getMyBoardList(map);
        } catch (Exception e) {
            throw e;
        }
    }

    public int getMyBoardCountingData(String userId) throws Exception {
        try {
            return boardDao.getMyBoardCountingData(userId);
        } catch (Exception e) {
            throw e;
        }
    }

    public FreeBoardVo getMyBoardDetailData(Map<String, Object> map) throws Exception {
        try {
            return boardDao.getMyBoardDetailData(map);
        } catch (Exception e) {
            throw e;
        }
     }
}

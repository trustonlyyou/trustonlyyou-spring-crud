package com.crowdfunding.board.service;

import com.crowdfunding.board.entity.FreeBoardVo;
import com.crowdfunding.board.repository.FreeBoardDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FreeBoardService {

    @Autowired
    FreeBoardDao boardDao;

    public List<FreeBoardVo> getBoardList () throws Exception {
        return boardDao.freeBoardList();
    }
}

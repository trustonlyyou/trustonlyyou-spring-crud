package com.crowdfunding.board.repository;

import com.crowdfunding.board.entity.FreeBoardVo;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class FreeBoardDao {

    @Autowired
    SqlSessionTemplate sessionTemplate;

    public List<FreeBoardVo> freeBoardList () throws Exception {
        return sessionTemplate.selectList("freeBoardList");
    }
}

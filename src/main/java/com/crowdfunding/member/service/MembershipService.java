package com.crowdfunding.member.service;

import com.crowdfunding.member.dao.MembershipDao;
import com.crowdfunding.member.entity.LoginVo;
import com.crowdfunding.member.entity.MemberVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class MembershipService {

    private static final Logger logger = LoggerFactory.getLogger(MembershipService.class);

    @Autowired
    private MembershipDao membershipDao;

    public void joinMembershipService(MemberVo memberVo) throws Exception {
        try {
            membershipDao.join_Membership(memberVo);
        }catch (Exception e) {
            throw e;
        }
    }

    public MemberVo loginService(LoginVo loginVo) throws Exception {
        try {
            return membershipDao.login(loginVo);
        } catch (Exception e) {
            throw e;
        }
    }

    public String findUserId(Map<String, Object> param) throws Exception {
        try {
            return membershipDao.getUserId(param);
        } catch (Exception e) {
            throw e;
        }
    }

    public Integer isUserPassword(Map<String, Object> param) throws Exception {
        try {
            return membershipDao.isUserPassword(param);
        } catch (Exception e) {
            throw e;
        }
    }

    public void changeUserPassword(Map<String, Object> param) throws Exception {
        try {
            membershipDao.changeUserPassword(param);
        } catch (Exception e) {
            throw e;
        }
    }
}

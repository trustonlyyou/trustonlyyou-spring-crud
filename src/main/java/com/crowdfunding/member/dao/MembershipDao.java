package com.crowdfunding.member.dao;

import com.crowdfunding.member.entity.LoginVo;
import com.crowdfunding.member.entity.MemberVo;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public class MembershipDao {

    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;

    public void join_Membership(MemberVo memberVo) throws Exception {
        try {
            sqlSessionTemplate.insert("join_membership", memberVo);
        } catch (Exception e) {
            throw e;
        }
    }

    public MemberVo login(LoginVo loginVo) throws Exception {
        try {
            return sqlSessionTemplate.selectOne("login_membership", loginVo);
        } catch (Exception e) {
            throw e;
        }
    }

    public String getUserId(Map<String, Object> param) throws Exception {
        try {
            return sqlSessionTemplate.selectOne("find_userId", param);
        } catch (Exception e) {
            throw e;
        }
    }

    public Integer isUserPassword(Map<String, Object> param) throws Exception {
        try {
            return sqlSessionTemplate.selectOne("find_userPassword", param);
        } catch (Exception e) {
            throw e;
        }
    }

    public void changeUserPassword(Map<String, Object> param) throws Exception {
        try {
            sqlSessionTemplate.update("change_userPassword", param);
        } catch (Exception e) {
            throw e;
        }
    }
}

/*
    <!--  join  -->
    <insert id="join_membership" parameterType="java.lang.String">
        insert into membership_table
            (userName, userId, userPassword, userPhone, userEmail)
        values
            (#{userName}, #{userId}, #{userPassword}, #{userPhone}, #{userEmail})
    </insert>
 */

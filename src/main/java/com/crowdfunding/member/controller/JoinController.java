package com.crowdfunding.member.controller;

import com.crowdfunding.member.entity.MemberVo;
import com.crowdfunding.member.service.MembershipService;
import com.crowdfunding.commons.util.EncryptionSHA256;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/membership")
public class JoinController {

    private static final Logger logger = LoggerFactory.getLogger(JoinController.class);

    @Autowired
    MembershipService service;

    // 회원가입
    @GetMapping("/join")
    public String join() {
        return "/membership/join";
    }

    @PostMapping("/join")
    public String joinPost(@ModelAttribute MemberVo memberVo) throws Exception {

        String encryptionPassword = EncryptionSHA256.encrypt(memberVo.getUserPassword());
        // SHA256(해쉬 알고리즘 이용) :: 복호화 불가능. 단방향. 속도가 빠름

        memberVo.setUserPassword(encryptionPassword);
        logger.info("New Client Join :: '{}'" , memberVo.getUserId());

        try {
            service.joinMembershipService(memberVo);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage());
        }

        return "redirect:/membership/joinResult";
    }

    @GetMapping("/joinResult")
    public String joinResult() {
        return "membership/join_result";
    }
}
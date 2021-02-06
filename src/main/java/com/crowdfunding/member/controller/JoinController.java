package com.crowdfunding.member.controller;

import com.crowdfunding.member.entity.MemberVo;
import com.crowdfunding.member.service.MembershipService;
import com.crowdfunding.util.EncryptionSHA256;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/membership")
public class JoinController {

    private static final Logger logger = LoggerFactory.getLogger(JoinController.class);

    @Autowired
    MembershipService service;

    // Test
    @GetMapping("/joinTest")
    public String joinTest() {
        return "/membership/jointest";
    }

    // 회원가입
    @GetMapping("/joinPage")
    public String join() {
        return "/membership/join";
    }

    @PostMapping("/joinPost")
    public String joinPost(@ModelAttribute MemberVo memberVo, HttpServletRequest request, HttpServletResponse response, HttpSession session, Model model, RedirectAttributes redirectAttributes) throws Exception {

        try {
            if (memberVo == null) {
                logger.error(memberVo.toString());
                model.addAttribute("chk", false);
                return "/membership/join";
            } else {
                String encryptionPassword = EncryptionSHA256.encrypt(memberVo.getUserPassword());
                memberVo.setUserPassword(encryptionPassword);
                logger.info(memberVo.toString());
                service.joinMembershipService(memberVo);
            }
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

// TODO: 2021-02-04 get - post - redirect 시에 void 로 처리


// 네스프레소 일리캡슐
// 네스프레소 스타벅스 캡슐
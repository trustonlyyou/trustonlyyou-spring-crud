package com.crowdfunding.member.controller;

import com.crowdfunding.member.entity.MemberVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class MyPageController {

    private static final Logger logger = LoggerFactory.getLogger(MyPageController.class);

    @GetMapping("/membership/mypage")
    public String myPage(HttpSession session, Model model) throws Exception {
        MemberVo memberVo = new MemberVo();
        try {
            memberVo = (MemberVo) session.getAttribute("userInfo");
        } catch (Exception e) {
            logger.error(e.getMessage());
            e.printStackTrace();
        }

        if (memberVo == null) {
            logger.error("User Information is null");
            return "redirect:/";
        }

        model.addAttribute("userInfo", memberVo);

        return "/membership/myPage";
    }

}

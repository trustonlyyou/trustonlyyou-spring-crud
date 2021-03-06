package com.crowdfunding.member.controller;

import com.crowdfunding.member.entity.LoginVo;
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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/membership")
public class LoginController {

    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    MembershipService service;

    // Login
    @GetMapping("/login")
    public String login() {
        return "/membership/login";
    }

    @PostMapping("/loginPost")
    public String loginPost(@ModelAttribute LoginVo loginVo, HttpSession session, RedirectAttributes redirectAttributes) throws Exception {

        MemberVo userInfo = new MemberVo();

        String encryptionPassword = EncryptionSHA256.encrypt(loginVo.getUserPassword());
        loginVo.setUserPassword(encryptionPassword);

        try {
            userInfo = service.loginService(loginVo);
        } catch (Exception e) {
            logger.error(e.getMessage());
            e.printStackTrace();
        }

        if (userInfo == null) {
            logger.info("No userInfo");
            redirectAttributes.addFlashAttribute("msg", "fail");

            return "redirect:/membership/login";
        }

        logger.info(userInfo.toString());

        session.setAttribute("userInfo", userInfo);
        // 세션에 회원 정보 담는다. 보안 유지로 데이터는 formatting 했다.

        return "forward:/";
    }
}

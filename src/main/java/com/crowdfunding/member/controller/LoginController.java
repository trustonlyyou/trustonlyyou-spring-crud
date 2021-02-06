package com.crowdfunding.member.controller;

import com.crowdfunding.member.entity.LoginVo;
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
    public String loginPost(@ModelAttribute LoginVo loginVo, Model model, HttpSession session) throws Exception {
        try {
            String encryptionPassword = EncryptionSHA256.encrypt(loginVo.getUserPassword());
            loginVo.setUserPassword(encryptionPassword);

            LoginVo result = service.loginService(loginVo);

            if (result == null) {
                logger.error(result.toString());
                model.addAttribute("message", "Fail Login");
                return "membership/login";
            } else {
                session.setAttribute("loginId", result.getUserId()); // low level
                model.addAttribute("loginId", result.getUserId());
            }

        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage());
        }
        return "redirect:/";
    }

//    @GetMapping("/loginSuccess")
//    public String loginSuccess() {
//        return "/membership/loginSuccess";
//    }
}

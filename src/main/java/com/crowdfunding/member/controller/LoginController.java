package com.crowdfunding.member.controller;

import com.crowdfunding.member.entity.LoginVo;
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

import javax.servlet.http.HttpServletRequest;
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
    public String loginPost(@ModelAttribute LoginVo loginVo, HttpServletRequest request, Model model, HttpSession session) throws Exception {

        MemberVo userInfo = new MemberVo();

        String encryptionPassword = EncryptionSHA256.encrypt(loginVo.getUserPassword());
        loginVo.setUserPassword(encryptionPassword);

        try {
            userInfo = service.loginService(loginVo);
            logger.error("loginService is error");
            return "/membership/login";
        } catch (Exception e) {
            logger.error(e.getMessage());
            e.printStackTrace();
        }

        if (userInfo == null || "".equals(userInfo.getUserId())) {
            logger.info("get userInfo is null or empty");
            model.addAttribute("msg", "Fail Login Check Your ID or Password");
            return "/membership/login";
        } else {
            session.setAttribute("userInfo", userInfo);
            return "forward:/";
        }

//        if (result != null && !"".equals(result)) {
//            logger.info("result :: " + result);
////            session.setAttribute("result", result);
//            request.getSession().setAttribute("result", result);
//            return "forward:/";
//        } else {
//            logger.info("result :: " + result);
//            model.addAttribute("message", "Fail Login");
//            logger.info("여기서 리다이렉트");
//            return "redirect:/membership/login";
//        }
    }

}
